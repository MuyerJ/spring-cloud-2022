package com.yejiang.cloud.controller;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.yejiang.cloud.service.HealthStatusService;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * Description: 
 * date: 2022/5/1 15:58
 * @author YeJiang
 * @version
 */
@RestController
public class DisCoveryController {
    @Autowired
    public DiscoveryClient discoveryClient;
    @Autowired
    public EurekaClient eurekaClient;
    @Autowired
    private HealthStatusService healthStatusService;

    @GetMapping("/click/{status}")
    public String click(@PathVariable(value = "status") int status) {
        healthStatusService.setStatus(status == 1);
        healthStatusService.health();
        return "ok";
    }
    @GetMapping("discoveryClient")
    public String client2() {
        List<String> services = discoveryClient.getServices();
        System.out.println("services:" + services);
        String description = discoveryClient.description();
        System.out.println("description:" + description);
        int order = discoveryClient.getOrder();
        System.out.println("order:" + order);
        return "ok";
    }

    @GetMapping("discoveryClient/service/{id}")
    public String client3(@PathVariable(value = "id") String serviceId) {
        List<ServiceInstance> instances = discoveryClient.getInstances(serviceId);
        for (ServiceInstance instance : instances) {
            System.out.println("instance:" + ToStringBuilder.reflectionToString(instance));
        }
        return "ok";
    }


    @GetMapping("discoveryClient/instance/{pathId}")
    public String client4(@PathVariable(value = "pathId") String pathId) {
        //根据instanceId找一个
        //List<InstanceInfo> instances = eurekaClient.getInstancesById(pathId);
        //根据application找一堆
        List<InstanceInfo> instances = eurekaClient.getInstancesByVipAddress(pathId, false);
        if (instances.size() > 0) {
            InstanceInfo instanceInfo = instances.get(0);
            if (instanceInfo.getStatus() == InstanceInfo.InstanceStatus.UP) {
                String url = "http://" + instanceInfo.getIPAddr() + ":" + instanceInfo.getPort() + "/hello";
                RestTemplate restTemplate = new RestTemplate();
                String resp = restTemplate.getForObject(url, String.class);
                return "resp:" + resp;
            }
        }
        return "??";
    }

}
