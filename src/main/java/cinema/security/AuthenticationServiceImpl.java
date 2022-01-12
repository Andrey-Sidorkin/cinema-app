package cinema.security;

import cinema.exception.AuthenticationException;
import cinema.exception.RegistrationException;
import cinema.lib.Inject;
import cinema.lib.Service;
import cinema.model.User;
import cinema.service.ShoppingCartService;
import cinema.service.UserService;
import cinema.util.HashUtil;
import java.util.Optional;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    private static final String VALID_EMAIL_PATTERN
            = "^(\\w+\\.?)+\\w+@([\\w]+\\.?)+\\w+$";
    private static final String VALID_PASSWORD_PATTERN
            = "^\\w{7,30}$";
    @Inject
    private UserService userService;
    @Inject
    private ShoppingCartService shoppingCartService;

    @Override
    public User login(String email, String password) throws AuthenticationException {
        Optional<User> userFromDb = userService.findByEmail(email);
        if (userFromDb.isPresent() && matchPasswords(password, userFromDb.get())) {
            return userFromDb.get();
        }
        throw new AuthenticationException("Incorrect email or password!");
    }

    @Override
    public User register(String email, String password) throws RegistrationException {
        if (email.matches(VALID_EMAIL_PATTERN)
                && userService.findByEmail(email).isEmpty()
                && password.matches(VALID_PASSWORD_PATTERN)) {
            User user = new User();
            user.setEmail(email);
            user.setPassword(password);
            userService.add(user);
            shoppingCartService.registerNewShoppingCart(user);
            return user;
        }
        throw new RegistrationException("Can't register user with email " + email);
    }

    private boolean matchPasswords(String rawPassword, User userFromDb) {
        String hashedPassword = HashUtil.hashPassword(rawPassword, userFromDb.getSalt());
        return hashedPassword.equals(userFromDb.getPassword());
    }
}
