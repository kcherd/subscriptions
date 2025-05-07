package ru.test.subscriptions.controller.dto;

import lombok.Builder;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Дто для объекта подписки.
 */
@Builder
public class SubscriptionDto {

    /**
     * Название сервиса.
     */
    private String serviceName;

    /**
     * Дата окончания оплаченного периода.
     */
    private LocalDate endDateOfPaidPeriod;

    /**
     * Стоимость подписки.
     */
    private BigDecimal subscriptionFee;
}
