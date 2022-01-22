package com.yejiang.cloud.fegin;

import com.yejiang.cloud.entities.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Description: 
 * date: 2022/1/19 17:48
 * @author YeJiang
 * @version
 */
@Component
@FeignClient(value = "PAYMENT-SERVICE")
@RequestMapping(value = "/payment")
public interface PaymentFeign {

    @GetMapping(value = "/get/{id}")
    CommonResult getById(@PathVariable("id") Long id);

    @GetMapping(value = "/feign/timeout")
    String paymentFeignTimeOut();
}
