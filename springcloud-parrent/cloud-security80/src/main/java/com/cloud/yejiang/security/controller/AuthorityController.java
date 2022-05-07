package com.cloud.yejiang.security.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description: 
 * date: 2022/5/7 13:33
 * @author YeJiang
 * @version
 */
@RestController
public class AuthorityController {

    @GetMapping("/admin")
    @Secured({"ROLE_admin"})
    public String admin() {
        System.out.println("admin !");
        return "admin ~";
    }

    @GetMapping("/api")
    @Secured({"ROLE_api"})
    public String api() {
        System.out.println("api !");
        return "api ~";
    }


    @GetMapping("/open")
    @Secured({"ROLE_admin", "ROLE_api"})
    public String open() {
        System.out.println("open !");
        return "open ~";
    }
}
