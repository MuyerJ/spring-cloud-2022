package com.yejiang.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Description: 
 * date: 2022/1/17 11:20
 * @author YeJiang
 * @version
 */
@SpringBootApplication
@EnableDiscoveryClient
public class MainProviderZK8003 {
    public static void main(String[] args) {
        SpringApplication.run(MainProviderZK8003.class, args);
    }
}
