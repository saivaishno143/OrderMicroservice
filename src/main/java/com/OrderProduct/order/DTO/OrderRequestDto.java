package com.OrderProduct.order.DTO;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderRequestDto {

    private Long userId;
    @JsonProperty("items")
    private List<OrderItemDto> Items;


}
