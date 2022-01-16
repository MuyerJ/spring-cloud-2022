package com.yejiang.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Description: 
 * date: 2022/1/16 23:40
 * @author YeJiang
 * @version
 */
@SpringBootApplication
@EnableEurekaClient
public class MainPayment8002 {
    public static void main(String[] args) {
        SpringApplication.run(MainPayment8002.class, args);
    }
}
