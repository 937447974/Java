package com.websocket.service;

import com.websocket.po.TextMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.MessagingException;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

/**
 * WebSocketService.java
 * 服务层
 * Created by 阳君 on 2017/10/22.
 * Copyright © 2017年 websocket. All rights reserved.
 */
@Service
public class WebSocketService {

    private Map<String, String> pool; // 连接池
    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @PostConstruct
    void init() {
        this.pool = new HashMap<String, String>();
    }

    public Map<String, String> getPool() {
        return pool;
    }

    /**
     * 连接
     *
     * @param simpSessionId 会话id
     * @param userId        用户id
     */
    public void connect(String simpSessionId, String userId) {
        if (!(StringUtils.isEmpty(simpSessionId) || StringUtils.isEmpty(userId))) {
            this.pool.put(simpSessionId, userId);
            TextMessage textMessage = new TextMessage(userId + "上线，当前在线人数：" + this.pool.size());
            this.simpMessagingTemplate.convertAndSend("/topic/message", textMessage);
        }
    }


    /**
     * 断开连接
     *
     * @param simpSessionId 会话id
     */
    public void disconnect(String simpSessionId) {
        String userId = this.pool.get(simpSessionId);
        if (userId != null) {
            this.pool.remove(simpSessionId);
            TextMessage textMessage = new TextMessage(userId + "离线，当前在线人数：" + this.pool.size());
            this.send(textMessage);
        }
    }

    /**
     * 给所有用户发送消息
     *
     * @param payload 消息
     * @throws MessagingException
     */
    public void send(Object payload) throws MessagingException {
        this.simpMessagingTemplate.convertAndSend("/topic/message", payload);
    }

    /**
     * 给指定用户发消息
     *
     * @param userId  用户id
     * @param payload 消息
     * @throws MessagingException
     */
    public void sendToUser(String userId, Object payload) throws MessagingException {
        this.simpMessagingTemplate.convertAndSendToUser(userId, "/message", payload);
    }

}
