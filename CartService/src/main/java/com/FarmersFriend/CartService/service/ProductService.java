package com.FarmersFriend.CartService.service;


import com.FarmersFriend.CartService.models.Product;

public interface ProductService {


    void deleteProduct(Long productId);
    void updateProduct(Long productId, Product productDTO);
}
