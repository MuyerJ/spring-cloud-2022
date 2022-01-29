package com.yejiang.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Description: 
 * date: 2022/1/29 15:27
 * @author YeJiang
 * @version
 */
@SpringBootApplication
@EnableDiscoveryClient
public class NacosConfig {

    public static void main(String[] args) {
        SpringApplication.run(NacosConfig.class, args);
    }
}
