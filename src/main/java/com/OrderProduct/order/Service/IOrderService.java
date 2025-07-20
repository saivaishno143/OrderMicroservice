package com.OrderProduct.order.Service;

import com.OrderProduct.order.DTO.CreateOrderResponseDto;
import com.OrderProduct.order.DTO.OrderRequestDto;

public interface IOrderService {

    CreateOrderResponseDto createOrder(OrderRequestDto request);

//    CreateOrderResponseDto updateOrder(OrderRequestDto request);


}
