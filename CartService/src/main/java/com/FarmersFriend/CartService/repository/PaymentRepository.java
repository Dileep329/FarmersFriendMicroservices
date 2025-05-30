package com.FarmersFriend.CartService.repository;

import com.FarmersFriend.CartService.models.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment,Long> {
}
