package ru.test.subscriptions.service;

import ru.test.subscriptions.controller.dto.UserDto;

/**
 * Сервис для работы с пользователями.
 */
public interface UserService {

    /**
     * Создание пользователя.
     *
     * @param user Данные пользователя.
     * @return Созданный пользователь.
     */
    UserDto createUser(UserDto user);

    /**
     * Получение данных пользователя по идентификатору.
     *
     * @param id Идентификатор пользователя.
     * @return Данные пользователя.
     */
    UserDto getUser(Long id);

    /**
     * Изменение данных пользователя.
     *
     * @param id   Идентификатор пользователя.
     * @param user Данные пользователя.
     * @return Измененные данные пользователя.
     */
    UserDto updateUser(Long id, UserDto user);

    /**
     * Удаление пользователя.
     *
     * @param id Идентификатор пользователя.
     */
    void deleteUser(Long id);
}
