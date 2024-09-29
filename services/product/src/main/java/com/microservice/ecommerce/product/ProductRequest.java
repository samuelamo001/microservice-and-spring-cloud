package com.microservice.ecommerce.product;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductRequest{
        Long productId;
        @NotNull(message = "Product name is required")
        String name;
        @NotNull(message = "Product description is required")
        String description;
        @Positive(message = "Available quantity should be positive")
        double availableQuantity;
        @Positive(message = "Price should be positive")
        BigDecimal price;
}



