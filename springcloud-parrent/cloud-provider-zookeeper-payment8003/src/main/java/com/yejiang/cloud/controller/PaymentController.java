package com.yejiang.cloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description: 
 * date: 2022/1/17 11:21
 * @author YeJiang
 * @version
 */
@RestController
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/payment/zk")
    public String getZKInfo() {
        return "cloud zk  :" + serverPort + " | " + System.currentTimeMillis();
    }
}
