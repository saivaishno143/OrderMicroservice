package com.OrderProduct.order.Mapper;

import com.OrderProduct.order.DTO.OrderItemDto;
import com.OrderProduct.order.entity.Order;
import com.OrderProduct.order.entity.OrderItem;

public class OrderItemMapper {
    public static OrderItem orderItemRequestDtoToOrderItemEntity(OrderItemDto orderItemDto, Order order,double PricePerUnit,double totalPrice){
        return OrderItem.builder().
                        productId(orderItemDto.getProductId())
                        .quantity(orderItemDto.getQuantity())
                        .PricePerUnit(PricePerUnit)
                        .totalPrice(totalPrice)
                        .order(order)
                        .build();
    }
}
