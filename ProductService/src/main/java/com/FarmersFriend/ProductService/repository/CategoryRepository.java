package com.FarmersFriend.ProductService.repository;



import com.FarmersFriend.ProductService.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    Category findByCategoryName(String categoryName);
}
