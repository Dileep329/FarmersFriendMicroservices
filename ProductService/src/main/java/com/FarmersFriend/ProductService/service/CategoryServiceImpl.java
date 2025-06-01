package com.FarmersFriend.ProductService.service;

import com.FarmersFriend.ProductService.exception.APIException;
import com.FarmersFriend.ProductService.exception.ResourceNotFoundException;
import com.FarmersFriend.ProductService.models.Category;
import com.FarmersFriend.ProductService.payload.CategoryDTO;
import com.FarmersFriend.ProductService.payload.CategoryResponse;
import com.FarmersFriend.ProductService.repository.CategoryRepository;
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

    @Autowired
    private CategoryKafkaProducer categoryKafkaProducer;

    @Override
    public CategoryResponse getAllUser(Integer pageNumber, Integer pageSize, String sortBy, String sortOrder) {
        Sort sortByAndOrder=sortOrder.equalsIgnoreCase("asc")
                ?Sort.by(sortBy).ascending()
                :Sort.by(sortBy).descending();
        Pageable pageDetails= PageRequest.of(pageNumber,pageSize,sortByAndOrder);
        Page<Category> categoryPage = categoryRepository.findAll(pageDetails);
        List<Category> savedCategory = categoryPage.getContent();
        if(savedCategory.isEmpty())
            throw new APIException("No Categories created till now");
         List<CategoryDTO> categoryDTOS = savedCategory.stream().map(Category -> modelMapper.map(Category, CategoryDTO.class)).toList();
        CategoryResponse categoryResponse = new CategoryResponse();
        categoryResponse.setContent(categoryDTOS);
        categoryResponse.setPageNumber(pageNumber);
        categoryResponse.setPageSize(pageSize);
        categoryResponse.setTotalElements(categoryPage.getTotalElements());
        categoryResponse.setTotalPages(categoryPage.getTotalPages());
        categoryResponse.setLastPage(categoryPage.isLast());
        return categoryResponse;
    }

    @Override
    public CategoryDTO saveCategory(CategoryDTO categoryDTO) {
      Category category=modelMapper.map(categoryDTO,Category.class);
        Category savedCategory = categoryRepository.findByCategoryName(categoryDTO.getCategoryName());
        if(savedCategory!=null){
            throw new APIException("Category with the category name "+category.getCategoryName()+" already exists");
        }
        categoryRepository.save(category);
        categoryKafkaProducer.sendCategoryEvent(category,"Created");
        return modelMapper.map(category,CategoryDTO.class);
    }

    @Override
    public CategoryDTO deleteCategory(Long categoryId) {
        Category category=categoryRepository.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("Category does not exist"));
        categoryRepository.deleteById(categoryId);
        categoryKafkaProducer.sendCategoryEvent(category,"DELETED");
        return modelMapper.map(category, CategoryDTO.class);
    }

    @Override
    public CategoryDTO updateCategory(CategoryDTO categoryDTO, Long categoryId) {
        Optional<Category> savedCategoryOptional = categoryRepository.findById(categoryId);
        Category savedCategory=savedCategoryOptional.orElseThrow(()->new ResourceNotFoundException("Category","categoryId",categoryId));
        Category updatedCategory = modelMapper.map(categoryDTO, Category.class);
        savedCategory.setCategoryName(updatedCategory.getCategoryName());
        categoryKafkaProducer.sendCategoryEvent(updatedCategory,"Updated");
        return categoryDTO;
    }

}
