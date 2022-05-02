package com.yejiang.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Description: 
 * date: 2022/5/2 10:33
 * @author YeJiang
 * @version
 */
@RestController
public class Hello81Controller {

    @Autowired
    private LoadBalancerClient loadBalancerClient;
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/hello81")
    public String hello81() {
        ServiceInstance serviceInstance = loadBalancerClient.choose("provider");
        System.out.println("serviceInstance ：" + serviceInstance.getPort());
        return restTemplate.getForObject("http://provider/hello", String.class);
    }


    @GetMapping("/sleep")
    public String sleep() {
        return restTemplate.getForObject("http://provider/sleep", String.class);
    }
}
