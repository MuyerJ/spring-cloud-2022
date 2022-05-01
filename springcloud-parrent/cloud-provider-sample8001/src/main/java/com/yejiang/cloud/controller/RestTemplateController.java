package com.yejiang.cloud.controller;

import com.yejiang.cloud.entity.Person;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * Description: 
 * date: 2022/5/1 15:59
 * @author YeJiang
 * @version
 */
@RestController
public class RestTemplateController {

    String URL = "http://127.0.0.1:8002/person";
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/getForEntity")
    public String getForEntity() {
        ResponseEntity<Person> entity = restTemplate.getForEntity(URL, Person.class);
        System.out.println("resp  -->  " + entity);
        Person person = entity.getBody();
        System.out.println("person:" + ToStringBuilder.reflectionToString(person));
        return "ok";
    }

    @GetMapping("/getForObject")
    public String getForObject() {
        Person person = restTemplate.getForObject(URL, Person.class);
        System.out.println("person -->" + ToStringBuilder.reflectionToString(person));
        return "ok";
    }


    @GetMapping("/getForEntity/params")
    public String getForEntity(String id, String name) {

        //1.
        Person p1 = restTemplate.getForObject(URL + "/params?id={1}&name={2}", Person.class, id, name);
        System.out.println("person1:" + ToStringBuilder.reflectionToString(p1));


        //2.
        Map<String, String> map = new HashMap<>();
        map.put("id", id);
        map.put("name", name);
        Person p2 = new RestTemplate().getForObject(URL + "/params?id={id}&name={name}", Person.class, map);
        System.out.println("person2:" + ToStringBuilder.reflectionToString(p2));


        return ToStringBuilder.reflectionToString(p1);
    }
}
