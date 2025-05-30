package com.FarmersFriend.CartService.repository;



import com.FarmersFriend.CartService.models.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductRepository extends JpaRepository<Product,Long> {


    @Query("SELECT p FROM Product p WHERE p.user.id = :userId")
    Page<Product> findByUser_UserId(Long userId, Pageable pageable);

    @Query("SELECT p FROM Product p WHERE p.category.categoryId = :categoryId AND p.user.userId = :userId")
    Page<Product> findByCategory_CategoryIdAndUser_UserId(Long categoryId, Long userId,Pageable pageable);

    @Query("SELECT p FROM Product p WHERE " +
            "(LOWER(p.productName) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
            "LOWER(p.description) LIKE LOWER(CONCAT('%', :keyword, '%'))) AND " +
            "p.user.userId = :userId")
    Page<Product> findByNameIgnoreCaseAndUserId(String keyword, Long userId, Pageable pageable);

    Page<Product> findByCategoryOrderByPriceAsc(Long categoryId, Pageable pageDetails);

    Page<Product> findByProductNameLikeIgnoreCase(String s, Pageable pageDetails);

}
