package ru.test.subscriptions.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.test.subscriptions.entity.User;

/**
 * Репозиторий для работы с пользователями.
 */
public interface UserRepository extends JpaRepository<User, Long> {
}
