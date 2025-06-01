package com.FarmersFriend.ProductService.service;

import com.FarmersFriend.ProductService.models.Product;
import com.FarmersFriend.ProductService.models.ProductEvent;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ProductKafkaProducer {

    private final KafkaTemplate<String, ProductEvent> kafkaTemplate;

    @Value("${kafka.topic.product:product-topic}")
    private String topicName;

    public ProductKafkaProducer(KafkaTemplate<String, ProductEvent> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendProductEvent(Product product, String eventType) {
        ProductEvent event = new ProductEvent(eventType, product);
        kafkaTemplate.send(topicName, event);
        System.out.println("Sent product event to Kafka: " + eventType + " - " + product.getProductName());
    }
}
