package com.yejiang.cloud.service;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * Description: 
 * date: 2022/5/2 12:32
 * @author YeJiang
 * @version
 */
public class HystrixDemo extends HystrixCommand {

    protected HystrixDemo(HystrixCommandGroupKey group) {
        super(group);
    }

    public static void main(String[] args) {
        Future<String> future = new HystrixDemo(HystrixCommandGroupKey.Factory.asKey("ext")).queue();
        String result = "";
        try {
            result = future.get();
        } catch (InterruptedException e) {
        } catch (ExecutionException e) {
        }
        System.out.println("执行的结果: " + result);

    }

    @Override
    protected Object run() throws Exception {
        System.out.println("执行的逻辑");
        int i = 1 / 0;
        return "ok";
    }

    @Override
    protected Object getFallback() {
        return "my fall back!";
    }
}
