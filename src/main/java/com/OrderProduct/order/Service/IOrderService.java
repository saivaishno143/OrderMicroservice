package com.OrderProduct.order.Service;

import com.OrderProduct.order.DTO.CreateOrderResponseDto;
import com.OrderProduct.order.DTO.OrderRequestDto;
import com.OrderProduct.order.DTO.OrderstatusUpdateDto;

public interface IOrderService {

    CreateOrderResponseDto createOrder(OrderRequestDto request);

//    CreateOrderResponseDto updateOrder(OrderRequestDto request);

    OrderstatusUpdateDto updateOrderStatus(Long orderId, String status);


}
