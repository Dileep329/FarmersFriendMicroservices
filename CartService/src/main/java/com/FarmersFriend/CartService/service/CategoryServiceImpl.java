package com.FarmersFriend.CartService.service;


import com.FarmersFriend.CartService.exception.APIException;
import com.FarmersFriend.CartService.exception.ResourceNotFoundException;
import com.FarmersFriend.CartService.models.Category;
import com.FarmersFriend.CartService.payload.CategoryDTO;
import com.FarmersFriend.CartService.payload.CategoryResponse;
import com.FarmersFriend.CartService.repository.CategoryRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService{


    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public Category saveCategory(Category category) {
//      Category category=modelMapper.map(categoryDTO,Category.class);
//        Category savedCategory = categoryRepository.findByCategoryName(categoryDTO.getCategoryName());
//        if(savedCategory!=null){
//            throw new APIException("Category with the category name "+category.getCategoryName()+" already exists");
//        }
        categoryRepository.save(category);
        return category;
    }

    @Override
    public Category deleteCategory(Long categoryId) {
        Category category=categoryRepository.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("Category does not exist"));
        categoryRepository.deleteById(categoryId);
        return category;
    }

    @Override
    public Category updateCategory(Category category, Long categoryId) {
        Optional<Category> savedCategoryOptional = categoryRepository.findById(categoryId);
        Category savedCategory=savedCategoryOptional.orElseThrow(()->new ResourceNotFoundException("Category","categoryId",categoryId));
//        Category updatedCategory = modelMapper.map(categoryDTO, Category.class);
        savedCategory.setCategoryName(savedCategory.getCategoryName());
        return category;
    }

}
