package com.yejiang.cloud.feign;

import com.yejiang.cloud.service.HystrixServiceFallBack;
import com.yejiang.cloud.service.HystrixServiceFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Description: 
 * date: 2022/5/2 12:56
 * @author YeJiang
 * @version
 */
@FeignClient(name = "provider", fallbackFactory = HystrixServiceFallbackFactory.class, fallback = HystrixServiceFallBack.class)
public interface HelloProvider {
    @GetMapping("/sleep")
    public String hello();
}
