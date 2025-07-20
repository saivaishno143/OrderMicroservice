package com.OrderProduct.order.controller;

import com.OrderProduct.order.DTO.CreateOrderResponseDto;
import com.OrderProduct.order.DTO.OrderRequestDto;
import com.OrderProduct.order.DTO.OrderstatusUpdateDto;
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
    @PatchMapping("/{orderId}/status")
    public ResponseEntity<OrderstatusUpdateDto> updateOrderStatus(
            @PathVariable Long orderId,
            @RequestBody OrderstatusUpdateDto statusUpdateDto) {

        OrderstatusUpdateDto response = orderService.updateOrderStatus(orderId, statusUpdateDto.getStatus());
        return ResponseEntity.ok(response);
    }


}
