package com.yejiang.cloud.controller;

import com.yejiang.cloud.entities.CommonResult;
import com.yejiang.cloud.entities.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

/**
 * Description: 
 * date: 2022/1/13 18:18
 * @author YeJiang
 * @version
 */
@RestController
@RequestMapping("/consumer")
public class Order80Controller {

//    public String PAYMENT8001_BASE_URL = "http://localhost:8001";
    public String PAYMENT_BASE_URL = "http://PAYMENT-SERVICE";
    public String PROVIDER = "http://provider";
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id) {
        return restTemplate.getForObject(PAYMENT_BASE_URL + "/payment/get/" + id, CommonResult.class, id);
    }

    @PostMapping("/payment/add")
    public CommonResult addPayment(Payment payment) {
        return restTemplate.postForObject(PAYMENT_BASE_URL + "/payment/insert", payment, CommonResult.class);
    }

    @GetMapping("/payment/zipkin")
    public String paymentZipkin() {
        return restTemplate.getForObject(PAYMENT_BASE_URL + "/payment/zipkin/", String.class);
    }


    @GetMapping("/provider1")
    public String provider1() {
        return restTemplate.getForObject(PROVIDER + "/hello", String.class);
    }

}
