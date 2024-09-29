package com.microservice.ecommerce.product;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductResponse{
    Long productId;
    String name;
    String description;
    double availableQuantity;
    BigDecimal price;
}


