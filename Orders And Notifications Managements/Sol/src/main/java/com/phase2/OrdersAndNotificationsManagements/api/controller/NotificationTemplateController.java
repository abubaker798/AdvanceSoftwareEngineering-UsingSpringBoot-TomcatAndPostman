package com.phase2.OrdersAndNotificationsManagements.api.controller;

import com.phase2.OrdersAndNotificationsManagements.api.model.NotificationTemplate;
import com.phase2.OrdersAndNotificationsManagements.server.NotificationTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class NotificationTemplateController {
    @Autowired
    NotificationTemplateService notificationTemplateService;
    @PostMapping("/addNotification")
    public ResponseEntity<String> addNotificationTemplate(@RequestBody NotificationTemplate template) {
        notificationTemplateService.addNotificationTemplate(template);
        return ResponseEntity.ok("Notification template added successfully.");
    }

    @GetMapping("/getAllNotification")
    public List<NotificationTemplate> getAllNotificationTemplates() {
        return notificationTemplateService.getAllNotificationTemplates();
    }

    @GetMapping("/{templateId}")
    public ResponseEntity<NotificationTemplate> getNotificationTemplateById(@PathVariable String templateId) {
        NotificationTemplate template = notificationTemplateService.getNotificationTemplateById(templateId);
        if (template != null) {
            return ResponseEntity.ok(template);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/updateNotification")
    public ResponseEntity<String> updateNotificationTemplate(@RequestBody NotificationTemplate updatedTemplate) {
        notificationTemplateService.updateNotificationTemplate(updatedTemplate);
        return ResponseEntity.ok("Notification template updated successfully.");
    }

    @DeleteMapping("/delete/{templateId}")
    public ResponseEntity<String> deleteNotificationTemplate(@PathVariable String templateId) {
        notificationTemplateService.deleteNotificationTemplate(templateId);
        return ResponseEntity.ok("Notification template deleted successfully.");
    }

}

