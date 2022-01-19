package com.yejiang.cloud.controller;

import com.yejiang.cloud.entities.CommonResult;
import com.yejiang.cloud.fegin.PaymentFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description: 
 * date: 2022/1/19 17:51
 * @author YeJiang
 * @version
 */
@RestController
public class PaymentFeignController {
    @Autowired
    private PaymentFeign paymentFeign;

    @GetMapping(value = "/paymentFeign/get/{id}")
    CommonResult getById(@PathVariable("id") Long id) {
        return paymentFeign.getById(id);
    }

}
