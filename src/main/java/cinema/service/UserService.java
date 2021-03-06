package cinema.service;

import cinema.model.User;
import java.util.Optional;

public interface UserService {
    User add(User user);

    User get(Long id);

    User update(User user);

    Optional<User> findByEmail(String email);
}
