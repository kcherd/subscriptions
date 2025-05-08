package ru.test.subscriptions.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.test.subscriptions.controller.dto.SubscriptionDto;
import ru.test.subscriptions.entity.Subscription;
import ru.test.subscriptions.entity.User;
import ru.test.subscriptions.repository.SubscriptionRepository;
import ru.test.subscriptions.repository.UserRepository;
import ru.test.subscriptions.service.SubscriptionService;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Service
public class SubscriptionServiceImpl implements SubscriptionService {

    public static final String USER_WITH_ID_NOT_FOUND = "User with id = {} not found";
    private final SubscriptionRepository subscriptionRepository;
    private final UserRepository userRepository;

    @Transactional
    @Override
    public void createSubscription(Long userId, SubscriptionDto subscriptionDto) {
        Optional<User> optionalUser = userRepository.findById(userId);
        if (optionalUser.isEmpty()) {
            log.info(USER_WITH_ID_NOT_FOUND, userId);
            return;
        }
        User user = optionalUser.get();
        Subscription saved = subscriptionRepository.save(Subscription.builder()
                .serviceName(subscriptionDto.getServiceName())
                .endDateOfPaidPeriod(subscriptionDto.getEndDateOfPaidPeriod())
                .subscriptionFee((subscriptionDto.getSubscriptionFee()))
                .user(user)
                .build());
        log.info("Subscription with id = {} for user with id = {} saved", saved.getId(), userId);
    }

    @Transactional
    @Override
    public List<SubscriptionDto> getSubscriptions(Long userId) {
        Optional<User> optionalUser = userRepository.findById(userId);
        if (optionalUser.isPresent()) {
            List<Subscription> subscriptions = optionalUser.get().getSubscriptions();
            return subscriptions.stream()
                    .map(SubscriptionDto::of)
                    .toList();
        }
        log.info(USER_WITH_ID_NOT_FOUND, userId);
        return null;
    }

    @Override
    public void deleteSubscription(Long userId, Long subscriptionId) {
        Optional<Subscription> optionalSubscription = subscriptionRepository.findById(subscriptionId);
        if (optionalSubscription.isPresent()) {
            Subscription subscription = optionalSubscription.get();
            if (!Objects.equals(subscription.getUser().getId(), userId)) {
                log.error("Subscription with id = {} does not apply to user with id = {}", subscriptionId, userId);
                return;
            }
            subscriptionRepository.deleteById(subscriptionId);
            log.info("Subscription with id = {} deleted", subscriptionId);
        }
    }

    @Override
    public List<String> getTop() {
        return subscriptionRepository.getTop();
    }
}
