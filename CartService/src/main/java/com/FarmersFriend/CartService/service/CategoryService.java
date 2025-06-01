package com.FarmersFriend.CartService.service;


import com.FarmersFriend.CartService.models.Category;
import com.FarmersFriend.CartService.payload.CategoryDTO;
import com.FarmersFriend.CartService.payload.CategoryResponse;
import jakarta.validation.Valid;

public interface CategoryService {

     Category saveCategory(Category category);

     Category deleteCategory(Long categoryId);

     Category updateCategory(@Valid Category category, Long categoryId);
}
