package com.yejiang.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Description: 
 * date: 2022/1/30 11:07
 * @author YeJiang
 * @version
 */
@SpringBootApplication
@EnableDiscoveryClient
public class SentinelMain {

    public static void main(String[] args) {
        SpringApplication.run(SentinelMain.class, args);
    }
}
