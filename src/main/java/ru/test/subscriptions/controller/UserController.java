package ru.test.subscriptions.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.test.subscriptions.controller.dto.SubscriptionDto;
import ru.test.subscriptions.controller.dto.UserDto;
import ru.test.subscriptions.service.SubscriptionService;
import ru.test.subscriptions.service.UserService;

import java.util.List;

import static ru.test.subscriptions.controller.Paths.ID;
import static ru.test.subscriptions.controller.Paths.SUBSCRIPTIONS;
import static ru.test.subscriptions.controller.Paths.SUBSCRIPTION_ID;
import static ru.test.subscriptions.controller.Paths.USERS;

@RequiredArgsConstructor
@RestController
@RequestMapping(USERS)
public class UserController {

    private final UserService userService;

    private final SubscriptionService subscriptionService;

    @PostMapping
    public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto user) {
        return ResponseEntity.ok(userService.createUser(user));
    }

    @GetMapping(ID)
    public ResponseEntity<UserDto> getUser(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getUser(id));
    }

    @PutMapping(ID)
    public ResponseEntity<UserDto> updateUser(@PathVariable Long id, @RequestBody UserDto user) {
        return ResponseEntity.ok(userService.updateUser(id, user));
    }

    @DeleteMapping(ID)
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }

    @PostMapping(ID + SUBSCRIPTIONS)
    public void createSubscription(
            @PathVariable Long id,
            @Valid @RequestBody SubscriptionDto subscriptionDto
    ) {
        subscriptionService.createSubscription(id, subscriptionDto);
    }

    @GetMapping(ID + SUBSCRIPTIONS)
    public ResponseEntity<List<SubscriptionDto>> getSubscription(@PathVariable Long id) {
        return ResponseEntity.ok(subscriptionService.getSubscriptions(id));
    }

    @DeleteMapping(ID + SUBSCRIPTIONS + SUBSCRIPTION_ID)
    public void deleteSubscription(@PathVariable Long id, @PathVariable("sub_id") Long subscriptionId) {
        subscriptionService.deleteSubscription(id, subscriptionId);
    }
}
