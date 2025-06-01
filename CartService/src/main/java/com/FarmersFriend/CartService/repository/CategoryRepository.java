package com.FarmersFriend.CartService.repository;

import com.FarmersFriend.CartService.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    Category findByCategoryName(String categoryName);
}
