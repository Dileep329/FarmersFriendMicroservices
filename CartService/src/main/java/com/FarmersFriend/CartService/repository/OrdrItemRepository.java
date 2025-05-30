package com.FarmersFriend.CartService.repository;


import com.FarmersFriend.CartService.models.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdrItemRepository extends JpaRepository<OrderItem,Long> {
}
