package com.yejiang.cloud;

import com.yejiang.cloud.service.TemplateInterceptor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

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

    @Bean
    public RestTemplate restTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getInterceptors().add(new TemplateInterceptor());
        return restTemplate;
    }
}
