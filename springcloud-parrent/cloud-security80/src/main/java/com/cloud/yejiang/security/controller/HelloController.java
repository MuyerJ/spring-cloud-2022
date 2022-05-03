package com.cloud.yejiang.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description: 
 * date: 2022/5/3 12:42
 * @author YeJiang
 * @version
 */
@RestController
public class HelloController {
    @GetMapping("/hello")
    public String hello() {
        System.out.println("hello !");
        return "hello ~";
    }
}
