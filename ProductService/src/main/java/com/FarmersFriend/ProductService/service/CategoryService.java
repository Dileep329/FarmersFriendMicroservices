package com.FarmersFriend.ProductService.service;

import com.FarmersFriend.ProductService.payload.CategoryDTO;
import com.FarmersFriend.ProductService.payload.CategoryResponse;
import jakarta.validation.Valid;

public interface CategoryService {

     CategoryResponse getAllUser(Integer pageNumber, Integer pageSize, String sortBy, String sortOrder);

     CategoryDTO saveCategory(CategoryDTO categoryDTO);

     CategoryDTO deleteCategory(Long categoryId);

     CategoryDTO updateCategory(@Valid CategoryDTO categoryDTO, Long categoryId);
}
