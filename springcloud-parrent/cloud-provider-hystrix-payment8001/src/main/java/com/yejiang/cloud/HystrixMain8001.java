package com.yejiang.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Description: 
 * date: 2022/1/20 13:46
 * @author YeJiang
 * @version
 */
@SpringBootApplication
@EnableEurekaClient
public class HystrixMain8001 {
    public static void main(String[] args) {
        SpringApplication.run(HystrixMain8001.class, args);
    }
}
