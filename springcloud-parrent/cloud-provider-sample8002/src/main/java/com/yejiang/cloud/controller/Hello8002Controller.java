package com.yejiang.cloud.controller;

import com.yejiang.cloud.entity.Person;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description: 
 * date: 2022/4/30 17:15
 * @author YeJiang
 * @version
 */
@RestController
public class Hello8002Controller {
    @GetMapping("/hello")
    public String hello() {
        return "hello 8002";
    }

    @GetMapping("/sleep")
    public String sleep() {
        System.out.println("8002 sleep");
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "8002 sleep";
    }

    @GetMapping("/person")
    public Person person() {
        return new Person("1", "yejiang");
    }

    @GetMapping("/person/params")
    public Person person(String id, String name) {
        return new Person(id, name);
    }
}
