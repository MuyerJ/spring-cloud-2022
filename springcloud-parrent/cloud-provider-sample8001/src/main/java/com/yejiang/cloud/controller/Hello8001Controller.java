package com.yejiang.cloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description: 
 * date: 2022/4/30 17:07
 * @author YeJiang
 * @version
 */
@RestController
public class Hello8001Controller {

    @GetMapping("/hello")
    public String hello() {
        return "8001 hello";
    }

    @GetMapping("/sleep")
    public String sleep() {
        System.out.println("8001 sleep");
        int i = 1 / 0;
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "8001 sleep";
    }

}
