package com.OrderProduct.order.Mapper;

import com.OrderProduct.order.DTO.CreateOrderResponseDto;
import com.OrderProduct.order.DTO.OrderRequestDto;
import com.OrderProduct.order.Enums.OrderStatus;
import com.OrderProduct.order.entity.Order;

public class OrderMapper {

    public static Order toEntity(OrderRequestDto requestDto){
        return Order.builder().
                userId(requestDto.getUserId())
                .orderStatus(OrderStatus.PENDING)
                .build();
    }

    public static CreateOrderResponseDto toCreteOrderResponseDto(Order order) {
        return CreateOrderResponseDto.builder()
                .OrderId(order.getId())
                .orderStatus(order.getOrderStatus())
                .build();
    }
}
