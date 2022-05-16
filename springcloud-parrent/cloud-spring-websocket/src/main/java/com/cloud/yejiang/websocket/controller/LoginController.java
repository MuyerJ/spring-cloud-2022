package com.cloud.yejiang.websocket.controller;

import com.alibaba.fastjson.JSONObject;
import com.cloud.yejiang.websocket.pojo.WeiXinReq;
import com.cloud.yejiang.websocket.util.WXUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

/**
 * Description: 
 * date: 2022/5/15 9:56
 * @author YeJiang
 * @version
 */
@RestController
public class LoginController {

    String appId = "";
    String appSecret = "";

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

    //微信小程序一键登录
    @PostMapping(path = "/miniApp/login")
    public Map<String, String> miniAppLogin(@RequestBody WeiXinReq weiXinReq) {
        //getSession
        String url = "https://api.weixin.qq.com/sns/jscode2session?appid=" + appId + "&secret=" + appSecret + "&js_code=" +
                weiXinReq.getJsCode() + "&grant_type=authorization_code";
        Map map;
        Map<String, String> resp = new HashMap<>();
        for (int i = 0; i < 3; i++) {
            try {
                String str = new RestTemplate().getForObject(url, String.class);
                map = JSONObject.parseObject(str, Map.class);
                String sessionKey = map.get("session_key").toString();
                System.out.println("sessionKey:" + sessionKey);
                System.out.println("encryptedData:" + weiXinReq.getEncryptedData());
                System.out.println("iv:" + weiXinReq.getIv());
                JSONObject jsonObject = WXUtils.decode(sessionKey, weiXinReq.getEncryptedData(), weiXinReq.getIv());
                if (Objects.nonNull(jsonObject)) {
                    resp.put("msg", jsonObject.toJSONString());
                    break;
                }

            } catch (Exception e) {
                resp.put("code", 401 + "");
                return resp;
            }
        }
        resp.put("code", 200 + "");
        resp.put("token", UUID.randomUUID().toString().substring(1, 8));
        return resp;
    }
}