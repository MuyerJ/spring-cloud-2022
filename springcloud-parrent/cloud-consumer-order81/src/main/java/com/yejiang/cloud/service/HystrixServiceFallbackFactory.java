package com.yejiang.cloud.service;

import com.netflix.hystrix.exception.HystrixTimeoutException;
import com.yejiang.cloud.feign.HelloProvider;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * Description: 
 * date: 2022/5/2 12:53
 * @author YeJiang
 * @version
 */
@Component
public class HystrixServiceFallbackFactory implements FallbackFactory<HelloProvider> {
    @Override
    public HelloProvider create(Throwable throwable) {
        throwable.printStackTrace();
        return new HelloProvider() {
            @Override
            public String hello() {
                if (throwable instanceof HystrixTimeoutException) {
                    return "HystrixTimeoutException";
                }
                return "hystrix";
            }
        };
    }
}
