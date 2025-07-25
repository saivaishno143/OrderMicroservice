package com.OrderProduct.order.Service;

import com.OrderProduct.order.DTO.*;
import com.OrderProduct.order.Enums.OrderStatus;
import com.OrderProduct.order.Mapper.OrderItemMapper;
import com.OrderProduct.order.Mapper.OrderMapper;
import com.OrderProduct.order.Repository.OrderRepository;
import com.OrderProduct.order.clients.ProductServiceclient;
import com.OrderProduct.order.entity.Order;
import com.OrderProduct.order.entity.OrderItem;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class OrderService implements IOrderService{

    private final OrderRepository orderRepository;
    private final ProductServiceclient productServiceclient;

    public OrderService(OrderRepository orderRepository,ProductServiceclient productServiceclient) {
        this.orderRepository = orderRepository;
        this.productServiceclient = productServiceclient;
    }

    @Override
    public CreateOrderResponseDto createOrder(OrderRequestDto request) {
        Order order = OrderMapper.toEntity(request);
        List<OrderItem> items=new ArrayList<>();
        for(OrderItemDto itemDto : request.getItems()){
            ProductDto product= productServiceclient.getProductById(itemDto.getProductId());
            double pricePerUnit = product.getPrice();
            double totalprice=pricePerUnit * itemDto.getQuantity();

            OrderItem item= OrderItemMapper.orderItemRequestDtoToOrderItemEntity(
                    itemDto,order,pricePerUnit,totalprice
            );
            items.add(item);
        }
        order.setOrderItems(items);
        Order createOrder = orderRepository.save(order);
        return OrderMapper.toCreteOrderResponseDto(createOrder);
    }
    public OrderstatusUpdateDto updateOrderStatus(Long orderId, String status) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found with ID: " + orderId));

        order.setOrderStatus(OrderStatus.valueOf(status));  // update status
        orderRepository.save(order);

        return new OrderstatusUpdateDto(orderId, status, "Order status updated successfully.");
    }



}
