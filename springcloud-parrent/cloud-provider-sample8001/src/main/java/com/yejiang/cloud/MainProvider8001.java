package com.yejiang.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Description: 
 * date: 2022/4/30 17:03
 * @author YeJiang
 * @version
 */
@SpringBootApplication
@EnableEurekaClient
public class MainProvider8001 {
    public static void main(String[] args) {
        SpringApplication.run(MainProvider8001.class, args);
    }
}
