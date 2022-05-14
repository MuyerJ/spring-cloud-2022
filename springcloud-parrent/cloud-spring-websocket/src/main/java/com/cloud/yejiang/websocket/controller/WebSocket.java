package com.cloud.yejiang.websocket.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * Description:
 * date: 2022/5/14 13:31
 * @author YeJiang
 * @version
 */
@Component
@ServerEndpoint("/webSocket")
@Slf4j
public class WebSocket {

    private static CopyOnWriteArraySet<WebSocket> webSockets = new CopyOnWriteArraySet<>();
    private Session session;

    public static void sendMessage(String message) {
        log.info("发送消息 : {} ", message);
        webSockets.forEach(webSocket -> {
            try {
                webSocket.session.getBasicRemote().sendText(message);
            } catch (IOException e) {
                log.info("error : {}", message);
            }
        });
    }

    @OnOpen
    public void onOpen(Session session) {
        this.session = session;
        webSockets.add(this);
        log.info("有新连接: total size = {}", webSockets.size());
    }

    @OnClose
    public void onClose() {
        webSockets.remove(this);
        log.info("连接断开: total size = {}", webSockets.size());
    }

    @OnMessage
    public void onMessage(String message) {
        log.info("发来的消息 , message = {}", message);
    }

}
