package com.phase2.OrdersAndNotificationsManagements.api.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class NotificationTemplate {
    private String templateId;
    private String subject;
    private String content;
    private List<String> availableLanguages;
    private List<String> availableChannels;
    private int numberOfPlaceholders;

    public NotificationTemplate() {}

    public NotificationTemplate(String templateId, String subject, String content,
                                List<String> availableLanguages, List<String> availableChannels,
                                int numberOfPlaceholders) {
        this.templateId = templateId;
        this.subject = subject;
        this.content = content;
        this.availableLanguages = availableLanguages;
        this.availableChannels = availableChannels;
        this.numberOfPlaceholders = numberOfPlaceholders;
    }
}

