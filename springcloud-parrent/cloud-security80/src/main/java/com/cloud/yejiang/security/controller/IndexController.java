package com.cloud.yejiang.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * Description: 
 * date: 2022/5/3 22:33
 * @author YeJiang
 * @version
 */
@Controller
public class IndexController {

    @PostMapping("/success")
    public String login1() {
        System.out.println("success");
        return "1";
    }

    @GetMapping("/login.html")
    public String login() {
        return "login";
    }

    @GetMapping("/error.html")
    public String error() {
        return "error";
    }
}
