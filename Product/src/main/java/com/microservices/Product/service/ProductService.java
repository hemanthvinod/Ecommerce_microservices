package com.microservices.Product.service;

import com.microservices.Product.domain.Product;
import com.microservices.Product.exception.ProductException;
import com.microservices.Product.mapper.ProductMapper;
import com.microservices.Product.repository.ProductRepository;
import com.microservices.Product.service.resource.ProductPurchaseRequest;
import com.microservices.Product.service.resource.ProductPurchaseResponse;
import com.microservices.Product.service.resource.ProductRequest;
import com.microservices.Product.service.resource.ProductResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public Long createProduct(ProductRequest productRequest) {
       Product product = productRepository.save(productMapper.toProduct(productRequest));
       return product.getId();
    }


    public List<ProductPurchaseResponse> purchaseProducts(List<ProductPurchaseRequest> productPurchaseRequests) {
            var productIds = productPurchaseRequests.stream()
                    .map(ProductPurchaseRequest::getProductId)
                    .toList();
            /// products present in the DB
            var storedProducts = productRepository.findAllByIdInOrderById(productIds);
            if(productIds.size() != storedProducts.size())
                throw new ProductException("PRODUCTS_PURCHASE_EXCEPTION","one or more products does not exist");
            /// products in the request
            var storedRequest = productPurchaseRequests.stream()
                    .sorted(Comparator.comparing(ProductPurchaseRequest::getProductId))
                    .toList();
            // purchased products
            var purchasedProducts = new ArrayList<ProductPurchaseResponse>();

            for(int i=0; i< storedProducts.size();i++){
                var product = storedProducts.get(i);
                var productRequest = storedRequest.get(i);
                if(product.getAvailableQuantity() < productRequest.getQuantity()){
                    throw new ProductException("INSUFFICIENT_STOCK_EXCEPTION","insufficient quantity of particular product");
                }
                var availableQuantity = product.getAvailableQuantity() - productRequest.getQuantity();
                product.setAvailableQuantity(availableQuantity);
                productRepository.save(product);
                purchasedProducts.add(productMapper.toProductPurchaseResponse(product, productRequest.getQuantity()));
            }
            return purchasedProducts;
    }

    public ProductResponse getProduct(Long Id) {
        return productRepository.findById(Id).map(productMapper::toProductResponse)
                .orElseThrow(
                        ()-> new ProductException("PRODUCT_NOT_FOUND_EXCEPTION", "the product with the given id is not found"));
    }

    public List<ProductResponse> getAllProducts() {
        return productRepository.findAll().stream()
                .map(productMapper::toProductResponse)
                .collect(Collectors.toList());
    }
}
