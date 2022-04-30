package com.yejiang.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Description: 
 * date: 2022/4/30 17:13
 * @author YeJiang
 * @version
 */
@SpringBootApplication
@EnableEurekaClient
public class MainProvider8002 {
    public static void main(String[] args) {
        SpringApplication.run(MainProvider8002.class, args);
    }
}
