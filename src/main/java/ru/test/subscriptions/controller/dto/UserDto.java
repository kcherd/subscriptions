package ru.test.subscriptions.controller.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import ru.test.subscriptions.entity.User;

import java.time.LocalDate;

/**
 * Дто для представления пользователя.
 */
@Builder
@Data
public class UserDto {

    /**
     * Идентификатор пользователя.
     */
    private Long id;

    /**
     * Имя пользователя.
     */
    @NotBlank
    private String name;

    /**
     * Фамилия пользователя.
     */
    private String surname;

    /**
     * Дата рождения.
     */
    @NotNull
    @JsonFormat(pattern = "dd.MM.yyyy")
    private LocalDate birthday;

    /**
     * Номер телефона.
     */
    private String phoneNumber;

    /**
     * Адрес электронной почты.
     */
    @NotBlank
    private String email;

    public static UserDto of(User user) {
        return UserDto.builder()
                .id(user.getId())
                .name(user.getName())
                .surname(user.getSurname())
                .birthday(user.getBirthday())
                .phoneNumber(user.getPhoneNumber())
                .email(user.getEmail())
                .build();
    }
}
