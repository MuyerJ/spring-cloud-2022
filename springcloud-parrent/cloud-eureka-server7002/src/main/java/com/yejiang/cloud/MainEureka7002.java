package com.yejiang.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Description: 
 * date: 2022/1/14 17:17
 * @author YeJiang
 * @version
 */
@SpringBootApplication
@EnableEurekaServer
public class MainEureka7002 {
    public static void main(String[] args) {
        SpringApplication.run(MainEureka7002.class, args);
    }
}
