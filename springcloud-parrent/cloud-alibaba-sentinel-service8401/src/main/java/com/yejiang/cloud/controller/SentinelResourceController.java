package com.yejiang.cloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.yejiang.cloud.handler.MyBlockHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description: 
 * date: 2022/2/2 19:39
 * @author YeJiang
 * @version
 */
@RestController
public class SentinelResourceController {
    @GetMapping("/rateLimit/myBlockHandler")
    @SentinelResource(value = "myBlockHandler",
            blockHandlerClass = MyBlockHandler.class, blockHandler = "handlerException1")
    public String test1() {
        return "ok!";
    }
}
