package com.microservices.Product.mapper;

import com.microservices.Product.domain.Category;
import com.microservices.Product.domain.Product;
import com.microservices.Product.service.resource.ProductPurchaseResponse;
import com.microservices.Product.service.resource.ProductRequest;
import com.microservices.Product.service.resource.ProductResponse;
import org.springframework.stereotype.Service;

@Service
public class ProductMapper {

    public Product toProduct(ProductRequest productRequest){
        return Product.builder()
                .name(productRequest.getName())
                .description(productRequest.getDescription())
                .availableQuantity(productRequest.getAvailableQuantity())
                .category(
                        Category.builder()
                                .Id(productRequest.getCategoryId()).build()
                ).build();
    }
    public ProductResponse toProductResponse(Product product){
        return new ProductResponse(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getAvailableQuantity(),
                product.getPrice(),
                product.getCategory().getId(),
                product.getName(),
                product.getCategory().getDescription()
        );
    }

    public ProductPurchaseResponse toProductPurchaseResponse(Product product, Double quantity) {
        return new ProductPurchaseResponse(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                quantity
        );
    }
}
