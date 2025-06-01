package com.FarmersFriend.CartService.models;

import lombok.Data;

@Data
public class ProductEvent {
    private String eventType; // e.g. "CREATED", "UPDATED"
    private Product product;

    public ProductEvent() {}

    public ProductEvent(String eventType, Product product) {
        this.eventType = eventType;
        this.product = product;
    }

    // Getters and setters
}
