package com.microservice.ecommerce.product;


import org.springframework.stereotype.Service;

@Service
public class ProductMapper {

    public  Product convertToEntity(ProductRequest request) {
        return Product.builder()
                .productId(request.getProductId())
                .name(request.getName())
                .description(request.getDescription())
                .availableQuantity(request.getAvailableQuantity())
                .price(request.getPrice())
                .build();
    }

    public  ProductResponse ConvertToResponse(Product product) {
        return ProductResponse.builder()
                .productId(product.getProductId())
                .name(product.getName())
                .description(product.getDescription())
                .availableQuantity(product.getAvailableQuantity())
                .price(product.getPrice())
                .build();
    }
}
