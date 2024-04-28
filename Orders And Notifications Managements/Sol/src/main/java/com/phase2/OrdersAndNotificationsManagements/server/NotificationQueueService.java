package com.phase2.OrdersAndNotificationsManagements.server;

import com.phase2.OrdersAndNotificationsManagements.api.model.Notification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

@Service
public class NotificationQueueService {
    private Queue<Notification> notificationQueue = new LinkedList<>();

    public void addNotification(Notification notification) {
        notificationQueue.add(notification);
    }

    public List<Notification> getNotificationQueue() {
        return new ArrayList<>(notificationQueue);
    }

    public Notification removeNotification() {
        if (!notificationQueue.isEmpty()) {
            return notificationQueue.poll();
        }
        return null;
    }

}
