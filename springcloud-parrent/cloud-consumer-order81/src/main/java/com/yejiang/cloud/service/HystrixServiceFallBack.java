package com.yejiang.cloud.service;

import com.yejiang.cloud.feign.HelloProvider;
import org.springframework.stereotype.Component;

/**
 * Description: 
 * date: 2022/5/2 13:16
 * @author YeJiang
 * @version
 */
@Component
public class HystrixServiceFallBack implements HelloProvider {
    @Override
    public String hello() {
        return "hello";
    }
}
