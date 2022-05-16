package com.cloud.yejiang.websocket.pojo;

import lombok.Data;

/**
 * Description: 
 * date: 2021/9/28 15:18
 * @author YeJiang
 * @version
 */
@Data
public class WeiXinReq {
    private String jsCode;
    private String encryptedData;
    private String iv;
}
