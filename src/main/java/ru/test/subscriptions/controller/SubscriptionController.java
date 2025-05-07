package ru.test.subscriptions.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static ru.test.subscriptions.controller.Paths.SUBSCRIPTIONS;
import static ru.test.subscriptions.controller.Paths.TOP;

@RestController
@RequestMapping(SUBSCRIPTIONS)
public class SubscriptionController {
    @GetMapping(TOP)
    public ResponseEntity<Void> getTop() {
        return null;
    }
}
