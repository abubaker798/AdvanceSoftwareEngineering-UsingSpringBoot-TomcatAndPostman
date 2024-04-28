package com.phase2.OrdersAndNotificationsManagements.api.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Setter
@Getter
public class Notification {
    private Long id;
    private Customer customer;
    private NotificationTemplate template;
    private Map<String, String> placeholderValues;
}
