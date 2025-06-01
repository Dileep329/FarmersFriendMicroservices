package com.farmers.friend.UserService.service;

import com.farmers.friend.UserService.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class UserKafkaProducer {

    private static final String TOPIC = "user-topic";

    @Autowired
    private KafkaTemplate<String, User> kafkaTemplate;

    public void sendUser(User user) {
        kafkaTemplate.send(TOPIC, user);
    }
}
