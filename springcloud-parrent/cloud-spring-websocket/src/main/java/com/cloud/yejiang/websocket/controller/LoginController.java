package com.cloud.yejiang.websocket.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * Description: 
 * date: 2022/5/15 9:56
 * @author YeJiang
 * @version
 */
@RestController
public class LoginController {
    @RequestMapping("/toLogin")
    public Map<String, Object> tologin(@RequestParam("user") String user,
                                       @RequestParam("pwd") String pwd,
                                       HttpSession session) {
        Map<String, Object> result = new HashMap<>();
        result.put("flag", true);
        session.setAttribute("user", user);
        return result;
    }

    @RequestMapping("/getUsername")
    public String getUsername(HttpSession session) {
        String username = (String) session.getAttribute("user");
        return username;
    }
}