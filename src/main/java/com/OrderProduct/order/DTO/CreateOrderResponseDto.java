package com.OrderProduct.order.DTO;

import com.OrderProduct.order.Enums.OrderStatus;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateOrderResponseDto {

    private Long OrderId;

    private OrderStatus orderStatus;
}
