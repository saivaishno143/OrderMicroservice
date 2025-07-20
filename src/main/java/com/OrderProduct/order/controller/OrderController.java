package com.OrderProduct.order.controller;

import com.OrderProduct.order.DTO.CreateOrderResponseDto;
import com.OrderProduct.order.DTO.OrderRequestDto;
import com.OrderProduct.order.Service.IOrderService;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    private final IOrderService orderService;

    public OrderController(IOrderService orderService) {
        this.orderService = orderService;
    }
    @PostMapping
    public ResponseEntity<CreateOrderResponseDto> createOrder(@RequestBody OrderRequestDto request) {

        CreateOrderResponseDto order=orderService.createOrder(request);
        return ResponseEntity.ok(order);
    }
//    @PatchMapping
//    public ResponseEntity<CreateOrderResponseDto> updateOrder(@RequestBody OrderRequestDto request) {
//        CreateOrderResponseDto order = orderService.updateOrder(request);
//        return ResponseEntity.ok(order);
//    }
}
