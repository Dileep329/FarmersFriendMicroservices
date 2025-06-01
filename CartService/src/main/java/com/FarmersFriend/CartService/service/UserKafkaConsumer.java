package com.FarmersFriend.CartService.service;

import com.FarmersFriend.CartService.models.User;
import com.FarmersFriend.CartService.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.concurrent.ConcurrentHashMap;

@Service
public class UserKafkaConsumer {

    @Autowired
    UserRepository userRepository;

    // In-memory store (or could be Redis/db for persistence)
    private final ConcurrentHashMap<String, User> userStore = new ConcurrentHashMap<>();

    @KafkaListener(topics = "user-topic", groupId = "cart-service-group", containerFactory = "userKafkaListenerContainerFactory")
    public void consume(User user) {
        System.out.println("Received user info from Kafka: " + user);


          userRepository.save(user);
        // Update local store (or database)
//        userStore.put(userDetails.getId(), userDetails);
    }

//    public UserDetails getUserById(String userId) {
//        return userStore.get(userId);
//    }
}
