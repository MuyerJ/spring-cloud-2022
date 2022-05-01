package com.yejiang.cloud.service;

import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

import java.io.IOException;

/**
 * Description: 
 * date: 2022/5/1 16:41
 * @author YeJiang
 * @version
 */
public class TemplateInterceptor implements ClientHttpRequestInterceptor {

    //拦截restTemplate请求
    @Override
    public ClientHttpResponse intercept(HttpRequest httpRequest, byte[] bytes, ClientHttpRequestExecution clientHttpRequestExecution) throws IOException {
        System.out.println("拦截URI:" + httpRequest.getURI());
        ClientHttpResponse response = clientHttpRequestExecution.execute(httpRequest, bytes);
        System.out.println("拦截Body:" + response.getBody());
        return response;
    }
}
