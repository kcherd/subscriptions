package ru.test.subscriptions.controller.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import ru.test.subscriptions.entity.Subscription;

import java.time.LocalDate;

/**
 * Дто для объекта подписки.
 */
@Builder(toBuilder = true)
@Data
public class SubscriptionDto {

    /**
     * Идентификатор подписки.
     */
    private Long id;

    /**
     * Название сервиса.
     */
    @NotBlank
    private String serviceName;

    /**
     * Дата окончания оплаченного периода.
     */
    @NotNull
    @JsonFormat(pattern = "dd.MM.yyyy")
    private LocalDate endDateOfPaidPeriod;

    /**
     * Стоимость подписки.
     */
    @NotNull
    private Double subscriptionFee;

    public static SubscriptionDto of(Subscription subscription) {
        return SubscriptionDto.builder()
                .id(subscription.getId())
                .serviceName(subscription.getServiceName())
                .endDateOfPaidPeriod(subscription.getEndDateOfPaidPeriod())
                .subscriptionFee(subscription.getSubscriptionFee())
                .build();
    }
}
