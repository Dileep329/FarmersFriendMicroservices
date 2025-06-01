package com.FarmersFriend.CartService.service;



import com.FarmersFriend.CartService.exception.ResourceNotFoundException;
import com.FarmersFriend.CartService.models.Product;
import com.FarmersFriend.CartService.repository.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl  implements ProductService{

    @Autowired
   private ProductRepository productRepository;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public void updateProduct(Long productId, Product product) {
        Product productFromDb = productRepository.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("Product", "productId", productId));

        productFromDb.setProductName(product.getProductName());
        productFromDb.setDescription(product.getDescription());
        productFromDb.setQuantity(product.getQuantity());
//        productFromDb.setDiscount(product.getDiscount());
        productFromDb.setPrice(product.getPrice());
//        productFromDb.setSpecialPrice(product.getSpecialPrice());
        Product savedProduct = productRepository.save(productFromDb);
    }

    @Override
    public void deleteProduct(Long productId) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("Product", "productId", productId));
        productRepository.delete(product);

    }

//    @Override
//    public ProductDTO updateProductImage(Long productId, MultipartFile image) throws IOException {
//        Product productFromDb = productRepository.findById(productId)
//                .orElseThrow(() -> new ResourceNotFoundException("Product", "productId", productId));
//
//        Object fileService = null;
//        String fileName = fileService.uploadImage(path, image);
//        productFromDb.setImage(fileName);
//
//        Product updatedProduct = productRepository.save(productFromDb);
//        return modelMapper.map(updatedProduct, ProductDTO.class);
//    }

}

