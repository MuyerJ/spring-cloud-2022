package com.cloud.yejiang.websocket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Description: 
 * date: 2022/5/14 16:14
 * @author YeJiang
 * @version
 */
@RestController
public class IndexController {

    @Autowired
    private WebSocket webSocket;
    private AtomicInteger orderNoCreator = new AtomicInteger();

    @GetMapping("/createOrder")
    public String createOrder() {
        int orderNo = orderNoCreator.getAndIncrement();
        webSocket.sendMessage(orderNo + "");
        return String.format("新增订单成功，订单号: %s", orderNo);
    }
}
