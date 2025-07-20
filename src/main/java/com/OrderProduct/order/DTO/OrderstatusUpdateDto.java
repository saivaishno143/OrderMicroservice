package com.OrderProduct.order.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class OrderstatusUpdateDto {
    private Long orderId;
    private String status;
    private String message;
}
