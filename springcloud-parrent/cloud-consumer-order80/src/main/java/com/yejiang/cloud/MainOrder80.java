package com.yejiang.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * Description: 
 * date: 2022/1/13 18:17
 * @author YeJiang
 * @version
 */
@SpringBootApplication
@EnableEurekaClient
public class MainOrder80 {

    public static void main(String[] args) {
        SpringApplication.run(MainOrder80.class, args);
    }

    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
