package ua.sukhyna.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.sukhyna.model.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findAllByName(String name);

    Optional<User> findUserByLogin(String login);
}
