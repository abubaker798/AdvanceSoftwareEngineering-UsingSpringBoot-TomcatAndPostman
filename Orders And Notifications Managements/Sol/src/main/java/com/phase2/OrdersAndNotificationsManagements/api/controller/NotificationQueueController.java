package com.phase2.OrdersAndNotificationsManagements.api.controller;

import com.phase2.OrdersAndNotificationsManagements.api.model.Notification;
import com.phase2.OrdersAndNotificationsManagements.server.NotificationQueueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class NotificationQueueController {
    @Autowired
    private NotificationQueueService notificationQueueService;
    @GetMapping("/printALLNotificationList")
    public List<Notification> getNotificationQueue() {
        return notificationQueueService.getNotificationQueue();
    }

}
