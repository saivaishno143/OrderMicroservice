package com.OrderProduct.order.clients;

import com.OrderProduct.order.DTO.ProductDto;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ProductServiceclient {

    private final RestTemplateBuilder restTemplateBuilder;

    public ProductServiceclient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplateBuilder = restTemplateBuilder;
    }

    public  ProductDto getProductById(Long productId) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        String url = "http://localhost:8080/api/products/" + productId; // Adjust the URL as needed
        ResponseEntity<ProductDto> response = restTemplate.getForEntity(url, ProductDto.class);
        return response.getBody();
    }


}
