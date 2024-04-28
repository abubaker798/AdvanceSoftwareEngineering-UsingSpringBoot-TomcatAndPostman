package com.phase2.OrdersAndNotificationsManagements.server;


import com.phase2.OrdersAndNotificationsManagements.api.model.NotificationTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NotificationTemplateService {
    private List<NotificationTemplate> notificationTemplates = new ArrayList<>();

    public void addNotificationTemplate(NotificationTemplate template) {
        notificationTemplates.add(template);
    }

    public List<NotificationTemplate> getAllNotificationTemplates() {
        return new ArrayList<>(notificationTemplates);
    }

    public NotificationTemplate getNotificationTemplateById(String templateId) {
        return notificationTemplates.stream()
                .filter(template -> template.getTemplateId().equals(templateId))
                .findFirst()
                .orElse(null);
    }

    public void deleteNotificationTemplate(String templateId) {
        notificationTemplates.removeIf(template -> template.getTemplateId().equals(templateId));
    }

    public void updateNotificationTemplate(NotificationTemplate updatedTemplate) {
        for (int i = 0; i < notificationTemplates.size(); i++) {
            NotificationTemplate template = notificationTemplates.get(i);
            if (template.getTemplateId().equals(updatedTemplate.getTemplateId())) {
                notificationTemplates.set(i, updatedTemplate);
                break;
            }
        }
    }
}
