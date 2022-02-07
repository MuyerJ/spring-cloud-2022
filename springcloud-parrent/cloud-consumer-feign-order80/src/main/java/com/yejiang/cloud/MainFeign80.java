package com.yejiang.cloud;

import com.yejiang.myrule.MySelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
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
@RibbonClient(name = "main-feign-80",configuration= MySelfRule.class)
public class MainFeign80 {
    public static void main(String[] args) {
        SpringApplication.run(MainFeign80.class, args);
    }
}
