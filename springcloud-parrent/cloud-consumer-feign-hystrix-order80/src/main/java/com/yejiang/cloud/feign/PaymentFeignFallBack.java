package com.yejiang.cloud.feign;

import org.springframework.stereotype.Component;

/**
 * Description: 
 * date: 2022/1/24 15:21
 * @author YeJiang
 * @version
 */
@Component
public class PaymentFeignFallBack implements PaymentFeign {
    @Override
    public String paymentInfo_OK(Integer id) {
        return "paymentInfo_OK fallBack";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "paymentInfo_TimeOut fallBack";
    }
}
