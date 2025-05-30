package com.FarmersFriend.CartService.repository;


import com.FarmersFriend.CartService.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Long> {
}
