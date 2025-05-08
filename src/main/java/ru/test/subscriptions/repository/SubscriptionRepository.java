package ru.test.subscriptions.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.test.subscriptions.entity.Subscription;

import java.util.List;

/**
 * Репозиторий для работы с подписками.
 */
public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {

    @Query(value = "select s.serviceName from Subscription s group by s.serviceName order by count(*) desc limit 3")
    List<String> getTop();
}
