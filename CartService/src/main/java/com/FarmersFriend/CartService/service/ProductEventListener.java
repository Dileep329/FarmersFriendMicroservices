package com.FarmersFriend.CartService.service;

import com.FarmersFriend.CartService.models.Cart;
import com.FarmersFriend.CartService.models.Product;
import com.FarmersFriend.CartService.models.ProductEvent;
import com.FarmersFriend.CartService.repository.CartRepository;
import com.FarmersFriend.CartService.repository.ProductRepository;
import com.FarmersFriend.CartService.util.AuthUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;


@Service
public class ProductEventListener {

    @Autowired
    private CartService cartService;

    @Autowired
    private ProductService productService;
    // Your service that manages cart operations

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private AuthUtil authUtil;

    @KafkaListener(topics = "product-topic", groupId = "cart-service-group",
                   containerFactory = "kafkaListenerContainerFactory")
    public void consumeProductEvent(ProductEvent event) {
        Product product = event.getProduct();
        String eventType = event.getEventType();

        System.out.println("Received event: " + eventType + " for product: " + product.getProductName());

        switch (eventType) {
            case "DELETED":
                Cart userCart  = cartRepository.findCartByEmail(authUtil.loggedInEmail());
                cartService.deleteProductFromCart(userCart.getCartId(),product.getProductId());
                productService.deleteProduct(product.getProductId());
                break;

            case "UPDATED":
                productService.updateProduct(product.getProductId(),product);
                break;

            case "CREATED":
                productRepository.save(product);
                break;

            // Optional: handle CREATED if needed
        }
    }
}
