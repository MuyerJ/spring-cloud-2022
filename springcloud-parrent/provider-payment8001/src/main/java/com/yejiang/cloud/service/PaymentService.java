package com.yejiang.cloud.service;

import com.yejiang.cloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * Description: 
 * date: 2022/1/13 17:43
 * @author YeJiang
 * @version
 */
public interface PaymentService {

    int insert(Payment payment);

    Payment getById(@Param("id") Long id);
}
