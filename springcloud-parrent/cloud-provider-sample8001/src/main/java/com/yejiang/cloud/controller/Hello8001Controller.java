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

}
