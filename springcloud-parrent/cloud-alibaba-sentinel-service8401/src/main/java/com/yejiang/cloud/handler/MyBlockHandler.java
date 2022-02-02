package com.yejiang.cloud.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;

/**
 * Description: 
 * date: 2022/2/2 19:37
 * @author YeJiang
 * @version
 */
public class MyBlockHandler {

    public static String handlerException1(BlockException exception) {
        return "my exception handler1 " + exception.getMessage();
    }

    public static String handlerException2(BlockException exception) {
        return "my exception handler2 " + exception.getMessage();
    }
}
