package com.FarmersFriend.CartService.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data

public class CategoryEvent {

//    @Getter
    private String eventType;
//    @Getter // "ADDED" or "UPDATED"
    private Category category;

    public CategoryEvent() {}

    public CategoryEvent(String eventType, Category category) {
        this.eventType = eventType;
        this.category = category;
    }
    // Constructors, getters, setters
}
