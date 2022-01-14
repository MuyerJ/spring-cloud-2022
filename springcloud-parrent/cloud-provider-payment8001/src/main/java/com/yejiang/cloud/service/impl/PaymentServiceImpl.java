package com.yejiang.cloud.service.impl;

import com.yejiang.cloud.dao.PaymentDao;
import com.yejiang.cloud.entities.Payment;
import com.yejiang.cloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Description: 
 * date: 2022/1/13 17:47
 * @author YeJiang
 * @version
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentDao paymentDao;

    @Override
    public int insert(Payment payment) {
        return paymentDao.insert(payment);
    }

    @Override
    public Payment getById(Long id) {
        return paymentDao.getById(id);
    }
}
