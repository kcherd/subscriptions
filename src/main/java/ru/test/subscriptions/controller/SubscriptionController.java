package ru.test.subscriptions.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.test.subscriptions.service.SubscriptionService;

import java.util.List;

import static ru.test.subscriptions.controller.Paths.SUBSCRIPTIONS;
import static ru.test.subscriptions.controller.Paths.TOP;

@RequiredArgsConstructor
@RestController
@RequestMapping(SUBSCRIPTIONS)
public class SubscriptionController {

    private final SubscriptionService subscriptionService;

    @GetMapping(TOP)
    public ResponseEntity<List<String>> getTop() {
        return ResponseEntity.ok(subscriptionService.getTop());
    }
}
