package com.yejiang.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Description: 
 * date: 2022/1/13 17:11
 * @author YeJiang
 * @version
 */
@SpringBootApplication
@EnableEurekaClient
public class MainPayment8001 {

    public static void main(String[] args) {
        SpringApplication.run(MainPayment8001.class, args);
    }
}
