package ru.test.subscriptions.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * Сущность для представления пользователя в базе данных.
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder(toBuilder = true)
@Entity
@Table(name = "user")
public class User {

    /**
     * Идентификатор записи.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Имя пользователя.
     */
    @Column(nullable = false)
    private String name;

    /**
     * Фамилия пользователя.
     */
    @Column
    private String surname;

    /**
     * Дата рождения.
     */
    @Column(nullable = false)
    private LocalDate birthday;

    /**
     * Номер телефона.
     */
    @Column(name = "phone_number")
    private String phoneNumber;

    /**
     * Адрес электронной почты.
     */
    @Column(nullable = false)
    private String email;
}
