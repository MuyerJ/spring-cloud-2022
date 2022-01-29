package com.yejiang.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Description: 
 * date: 2022/1/29 14:29
 * @author YeJiang
 * @version
 */
@SpringBootApplication
@EnableDiscoveryClient
public class AlibabaPaymentMain9002 {
    public static void main(String[] args) {
        SpringApplication.run(AlibabaPaymentMain9002.class, args);
    }
}
