package com.yejiang.statemachine.order.model;

import lombok.Data;

@Data
public class Order {
    private Long orderId;
    private OrderStatus status;
}
