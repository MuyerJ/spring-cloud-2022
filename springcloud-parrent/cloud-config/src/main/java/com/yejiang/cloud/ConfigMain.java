package com.yejiang.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * Description: 
 * date: 2022/1/26 13:40
 * @author YeJiang
 * @version
 */
@SpringBootApplication
@EnableConfigServer
public class ConfigMain {

    public static void main(String[] args) {
        SpringApplication.run(ConfigMain.class, args);
    }
}
