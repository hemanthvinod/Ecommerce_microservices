package com.microservices.Order.product;

import com.microservices.Order.exception.OrderException;
import com.microservices.Order.service.resource.PurchaseRequest;
import com.microservices.Order.service.resource.PurchaseResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.apache.hc.core5.http.HttpHeaders.CONTENT_TYPE;
import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@Service
@RequiredArgsConstructor
public class ProductClient {

    @Value("${application.config.product-url}")
    private String productUrl;
    private final RestTemplate restTemplate;

    public List<PurchaseResponse> purchaseProducts(List<PurchaseRequest> requestBody){
        HttpHeaders headers = new HttpHeaders();
        headers.set(CONTENT_TYPE, APPLICATION_JSON_VALUE);

        HttpEntity<List<PurchaseRequest>> requestEntity = new HttpEntity<>(requestBody, headers);
        ParameterizedTypeReference<List<PurchaseResponse>> responseType = new ParameterizedTypeReference<>() {};
        ResponseEntity<List<PurchaseResponse>> responseEntity =
                restTemplate.exchange(productUrl + "/purchase",
                        HttpMethod.POST,
                        requestEntity,
                        responseType
                );

        if(responseEntity.getStatusCode().isError()){
            throw new OrderException("PRODUCT_PURCHASE_EXCEPTION","error while purchasing product " + responseEntity.getStatusCode());
        }
        return responseEntity.getBody();
    }

}
