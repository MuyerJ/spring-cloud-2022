package com.yejiang.mvc.sse.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Random;

/**
 * Description: 
 * date: 2022/6/13 17:16
 * @author YeJiang
 * @version
 */
@Controller
public class SSEController {

    /**
     * 返回结果 需要有固定格式 --> 开头 "data:"  结束 "\n\n"
     * @return
     */
    @RequestMapping(value = "/push", produces = "text/event-stream;charset=utf-8")
    @ResponseBody
    public String push() {
        Random r = new Random();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "data:Testing 1,2,3" + r.nextInt() + "\n\n";
    }

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String getSSEView () {
        return "index";
    }
}
