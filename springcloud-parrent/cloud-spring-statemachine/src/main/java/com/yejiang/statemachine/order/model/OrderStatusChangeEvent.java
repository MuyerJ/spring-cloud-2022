package com.yejiang.statemachine.order.model;

public enum OrderStatusChangeEvent {
    // 支付，发货，确认收货
    PAYED,
    DELIVERY,
    RECEIVED;
}
