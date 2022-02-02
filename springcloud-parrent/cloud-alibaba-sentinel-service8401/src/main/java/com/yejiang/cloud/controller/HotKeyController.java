package com.yejiang.cloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description:
 *  热点key 配置索引为0 ，超过阈值 报错： com.alibaba.csp.sentinel.slots.block.flow.param.ParamFlowException
 *
 * date: 2022/2/2 18:55
 * @author YeJiang
 * @version
 */
@RestController
public class HotKeyController {

    @GetMapping(value = "/hotKey1")
    //@SentinelResource(value = "hotKey2")
    @SentinelResource(value = "hotKey2", blockHandler = "deal_function")
    public String hotKey(@RequestParam(value = "p1", required = false) String p1,
                         @RequestParam(value = "p2", required = false) String p2) {
        System.out.println(p1 + p2);
        return "test hot key : p1 --> " + p1 + ", p2 -->" + p2;
    }

    public String deal_function(String p1, String p2, BlockException exception) {
        return "test hot key my paramException";
    }

}
