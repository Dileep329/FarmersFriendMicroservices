package com.FarmersFriend.ProductService.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryEvent {
    private String eventType; // "ADDED" or "UPDATED"
    private Category category;

    // Constructors, getters, setters
}
