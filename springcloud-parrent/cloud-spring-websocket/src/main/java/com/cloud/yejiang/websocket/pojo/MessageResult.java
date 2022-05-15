package com.cloud.yejiang.websocket.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Description: 
 * date: 2022/5/15 9:53
 * @author YeJiang
 * @version
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MessageResult {
    private boolean isSystem;
    private String fromName;
    private Object message;
}
