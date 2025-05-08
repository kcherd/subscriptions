package ru.test.subscriptions.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.test.subscriptions.controller.dto.UserDto;
import ru.test.subscriptions.entity.User;
import ru.test.subscriptions.repository.UserRepository;
import ru.test.subscriptions.service.UserService;

import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    public static final String USER_WITH_ID_NOT_FOUND = "User with id = {} not found.";
    private final UserRepository userRepository;

    @Override
    public UserDto createUser(UserDto user) {
        User createdUser = User.builder()
                .name(user.getName())
                .surname(user.getSurname())
                .birthday(user.getBirthday())
                .phoneNumber(user.getPhoneNumber())
                .email(user.getEmail())
                .build();
        log.info("User with id = {} created", createdUser.getId());
        return UserDto.of(userRepository.save(createdUser));
    }

    @Override
    public UserDto getUser(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            return UserDto.of(optionalUser.get());
        }
        log.info(USER_WITH_ID_NOT_FOUND, id);
        return null;
    }

    @Override
    public UserDto updateUser(Long id, UserDto user) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            User foundUser = optionalUser.get();
            foundUser = foundUser.toBuilder()
                    .name(Optional.ofNullable(user.getName()).orElse(foundUser.getName()))
                    .surname(Optional.ofNullable(user.getSurname()).orElse(foundUser.getSurname()))
                    .birthday(Optional.ofNullable(user.getBirthday()).orElse(foundUser.getBirthday()))
                    .phoneNumber(Optional.ofNullable(user.getPhoneNumber()).orElse(foundUser.getPhoneNumber()))
                    .email(Optional.ofNullable(user.getEmail()).orElse(foundUser.getEmail()))
                    .build();
            log.info("User with id = {} updated", foundUser.getId());
            return UserDto.of(userRepository.save(foundUser));
        }
        log.info(USER_WITH_ID_NOT_FOUND, id);
        return null;
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
        log.info("User with id = {} deleted", id);
    }
}
