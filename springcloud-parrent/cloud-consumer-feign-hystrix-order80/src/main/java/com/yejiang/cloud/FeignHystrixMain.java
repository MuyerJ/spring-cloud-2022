package com.yejiang.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Description: 
 * date: 2022/1/21 14:39
 * @author YeJiang
 * @version
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@EnableHystrix
public class FeignHystrixMain {
    public static void main(String[] args) {
        SpringApplication.run(FeignHystrixMain.class, args);
    }
}
