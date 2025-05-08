package ru.test.subscriptions.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * Сущность для представления подписки в базе данных.
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder(toBuilder = true)
@Entity
@Table(name = "subscription")
public class Subscription {

    /**
     * Идентификатор записи.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Название сервиса.
     */
    @Column(name = "service_name", nullable = false)
    private String serviceName;

    /**
     * Дата окончания оплаченного периода.
     */
    @Column(name = "end_date_of_paid_period", nullable = false)
    private LocalDate endDateOfPaidPeriod;

    /**
     * Стоимость подписки.
     */
    @Column(name = "subscription_fee", nullable = false)
    private Double subscriptionFee;

    /**
     * Информация о пользователе.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}
