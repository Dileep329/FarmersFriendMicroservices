package com.FarmersFriend.CartService.service;

import com.FarmersFriend.CartService.models.Category;
import com.FarmersFriend.CartService.models.CategoryEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class CategoryEventListener {

    @Autowired
    private CategoryService categoryService;

    @KafkaListener(
        topics = "category-topic",
        groupId = "cart-service-category-group",
        containerFactory = "categoryKafkaListenerContainerFactory"
    )
    public void listen(CategoryEvent event) {
        String eventType = event.getEventType();
        Category category = event.getCategory();


        switch (eventType) {
            case "Created":
                categoryService.saveCategory(category);
                System.out.println("Category added: " + category.getCategoryName());
                break;

            case "UPDATED":
                categoryService.updateCategory(category,category.getCategoryId());
                System.out.println("Category updated: " + category.getCategoryName());
                break;

            case "DELETED":
                categoryService.deleteCategory(category.getCategoryId());
                System.out.println("Category deleted: " + category.getCategoryName());
                break;

            default:
                System.out.println("Unhandled event type: " + eventType);
        }
    }
}
