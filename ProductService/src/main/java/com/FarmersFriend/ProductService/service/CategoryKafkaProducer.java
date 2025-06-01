package com.FarmersFriend.ProductService.service;

import com.FarmersFriend.ProductService.models.Category;
import com.FarmersFriend.ProductService.models.CategoryEvent;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class CategoryKafkaProducer {

    private final KafkaTemplate<String, CategoryEvent> kafkaTemplate;

    @Value("${kafka.topic.category:category-topic}")
    private String topic;

    public CategoryKafkaProducer(KafkaTemplate<String, CategoryEvent> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendCategoryEvent(Category category, String eventType) {
        CategoryEvent event = new CategoryEvent(eventType, category);
        kafkaTemplate.send(topic, event);
        System.out.println("Sent Kafka category event: " + eventType + " - " + category.getCategoryName());
    }
}
