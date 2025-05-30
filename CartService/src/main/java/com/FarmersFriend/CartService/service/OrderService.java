package com.FarmersFriend.CartService.service;


import com.FarmersFriend.CartService.payload.OrderDTO;

public interface OrderService {
    OrderDTO placeOrder(String emailId, String paymentMethod, String pgName, String pgPaymentId, String pgStatus, String pgResponseMessage);
}
