package com.yejiang.cloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.yejiang.cloud.feign.HelloProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description: 
 * date: 2022/5/2 12:50
 * @author YeJiang
 * @version
 */
@RestController
public class HystrixController {

    @Autowired
    private HelloProvider helloProvider;

    @GetMapping("/hystrix1")
    public String hystrix1() {
        return helloProvider.hello();
    }

    @GetMapping("/hystrix2")
    @HystrixCommand(fallbackMethod = "back")
    public String hystrix2() {
        int i = 1 / 0;
        return "ok";
    }

    public String back() {
        return "back";
    }
}
