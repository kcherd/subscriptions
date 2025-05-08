package ru.test.subscriptions.service;

import ru.test.subscriptions.controller.dto.SubscriptionDto;

import java.util.List;

/**
 * Сервис по работе с подписками.
 */
public interface SubscriptionService {

    /**
     * Создание подписки.
     *
     * @param userId          Идентификатор пользователя.
     * @param subscriptionDto Данные о подписке.
     */
    void createSubscription(Long userId, SubscriptionDto subscriptionDto);

    /**
     * Получение подписок пользователя.
     *
     * @param userId Идентификатор пользователя.
     * @return Подписки пользователя.
     */
    List<SubscriptionDto> getSubscriptions(Long userId);

    /**
     * Удаление подписки.
     *
     * @param userId         Идентификатор пользователя.
     * @param subscriptionId Идентификатор подписки.
     */
    void deleteSubscription(Long userId, Long subscriptionId);

    /**
     * Топ 3 популярных подписки.
     *
     * @return Список подписок.
     */
    List<String> getTop();
}
