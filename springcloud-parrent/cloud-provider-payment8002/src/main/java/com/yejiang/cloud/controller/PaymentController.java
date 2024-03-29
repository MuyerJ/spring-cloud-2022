package com.yejiang.cloud.controller;

import com.yejiang.cloud.entities.CommonResult;
import com.yejiang.cloud.entities.Payment;
import com.yejiang.cloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

/**
 * Description: 
 * date: 2022/1/13 17:49
 * @author YeJiang
 * @version
 */
@RestController
@RequestMapping(value = "/payment")
@Slf4j
public class PaymentController {


    @Autowired
    private PaymentService paymentService;
    @Value("${server.port}")
    private String port;

    @PostMapping(value = "/insert")
    public CommonResult insert(@RequestBody Payment payment) {
        int result = paymentService.insert(payment);
        log.info("payment insert | {}", result);
        return result > 0 ? new CommonResult(200, "插入数据成功") :
                new CommonResult(400, "插入数据失败");
    }

    @GetMapping(value = "/get/{id}")
    public CommonResult getById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getById(id);
        log.info("payment get|port = {} ---- | {} ", port, payment);
        return Objects.nonNull(payment) ? new CommonResult(200, "查询成功" + port, payment) :
                new CommonResult(400, "没有对应的记录", null);
    }
}
