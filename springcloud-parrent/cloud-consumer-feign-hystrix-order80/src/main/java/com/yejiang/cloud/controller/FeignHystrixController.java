package com.yejiang.cloud.controller;

import com.yejiang.cloud.feign.PaymentFeign;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description: 
 * date: 2022/1/22 16:01
 * @author YeJiang
 * @version
 */
@RestController
@Slf4j
public class FeignHystrixController {

    @Autowired
    private PaymentFeign paymentFeign;

    @GetMapping("/consumer/hystrix/ok/{id}")
    String paymentInfo_OK(@PathVariable("id") Integer id) {
        return paymentFeign.paymentInfo_OK(id);
    }

    @GetMapping("/consumer/hystrix/timeout/{id}")
    String paymentInfo_TimeOut(@PathVariable("id") Integer id) {
        return paymentFeign.paymentInfo_TimeOut(id);
    }
}
