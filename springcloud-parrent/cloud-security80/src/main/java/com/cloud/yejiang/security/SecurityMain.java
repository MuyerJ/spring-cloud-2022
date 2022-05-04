package com.cloud.yejiang.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

/**
 * Description: 
 * date: 2022/5/3 12:41
 * @author YeJiang
 * @version
 */
@SpringBootApplication
@EnableWebSecurity
public class SecurityMain {
    public static void main(String[] args) {
        SpringApplication.run(SecurityMain.class, args);
    }
}
