package com.cloud.yejiang.websocket.util;

import com.cloud.yejiang.websocket.pojo.MessageResult;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Description: 
 * date: 2022/5/15 9:55
 * @author YeJiang
 * @version
 */
public class MessageUtils {
    public static String getMessage(boolean isSystemMessage, String fromName, Object message) {
        try {
            MessageResult result = new MessageResult();
            result.setSystem(isSystemMessage);
            result.setMessage(message);
            if (fromName != null) {
                result.setFromName(fromName);
            }
            //把字符串转成json格式的字符串
            ObjectMapper mapper = new ObjectMapper();
            return mapper.writeValueAsString(result);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
