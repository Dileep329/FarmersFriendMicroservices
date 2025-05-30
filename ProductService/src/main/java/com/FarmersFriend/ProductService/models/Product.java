package com.FarmersFriend.ProductService.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;


    @NotBlank
    @Size(min = 3,message = "Product name must contain least 3 characters")
    private String productName;
    private String imageUrl;


    @NotBlank
    @Size(min = 6,message = "Product name must contain least 3 characters")
    private String description;
    private Integer quantity;
    private double price;

    @ManyToOne
    @JoinColumn(name="category_Name")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "seller_id")
    private User user;

}
