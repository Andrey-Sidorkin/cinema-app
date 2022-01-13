package cinema.dao;

import cinema.model.User;
import java.util.Optional;

public interface UserDao {
    User add(User user);

    User update(User user);

    Optional<User> get(Long id);

    Optional<User> findByEmail(String email);
}
