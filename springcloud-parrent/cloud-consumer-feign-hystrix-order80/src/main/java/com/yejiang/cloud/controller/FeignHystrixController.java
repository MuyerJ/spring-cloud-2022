package com.yejiang.cloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
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
    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOut_fallback", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1000")
    })
    String paymentInfo_TimeOut(@PathVariable("id") Integer id) {
        return paymentFeign.paymentInfo_TimeOut(id);
    }


    String paymentInfo_TimeOut_fallback(@PathVariable("id") Integer id) {
        return "80端口服务 熔断";
    }
}
