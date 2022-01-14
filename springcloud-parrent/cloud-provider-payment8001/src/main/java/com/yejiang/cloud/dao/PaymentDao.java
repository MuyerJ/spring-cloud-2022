package com.yejiang.cloud.dao;

import com.yejiang.cloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * Description: 
 * date: 2022/1/13 17:16
 * @author YeJiang
 * @version
 */
@Mapper
public interface PaymentDao {

    int insert(Payment payment);

    Payment getById(@Param("id") Long id);
}
