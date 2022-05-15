package com.cloud.yejiang.websocket.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Description: 
 * date: 2022/5/15 9:52
 * @author YeJiang
 * @version
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Message {
    private String toName;
    private String message;
}
