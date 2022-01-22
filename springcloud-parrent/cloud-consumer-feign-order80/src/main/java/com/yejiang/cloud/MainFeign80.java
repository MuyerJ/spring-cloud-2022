package com.yejiang.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Description: 
 * date: 2022/1/19 17:46
 * @author YeJiang
 * @version
 */

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class MainFeign80 {
    public static void main(String[] args) {
        SpringApplication.run(MainFeign80.class, args);
    }
}
