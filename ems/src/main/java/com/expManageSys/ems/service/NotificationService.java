package com.expManageSys.ems.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    private static final String NOTIFICATION_QUEUE = "notificationQueue";

    public void sendNotification(String message) {
        rabbitTemplate.convertAndSend(NOTIFICATION_QUEUE, message);
    }
}