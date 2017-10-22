package com.websocket.controller;

import com.websocket.po.TextMessage;
import com.websocket.service.WebSocketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * WebSocketController.java
 * <p>
 * Created by 阳君 on 2017/10/20.
 * Copyright © 2017年 websocket. All rights reserved.
 */
@MessageMapping("/stomp")
@RestController
public class WebSocketController {
    // @SendTo("/topic/message") 广播发送给 /topic/message 订阅客户端
    // @SendToUser("1/message") 发送给指定订阅用户

    @Autowired
    public WebSocketService webSocketService;

    @MessageMapping("/send")
    public void sendBroadcast(@Headers Map<String, Object> headers, @Header String simpSessionId, TextMessage
            textMessage) {
        TextMessage sendTM = new TextMessage(this.webSocketService.getPool().get(simpSessionId) + ": " + textMessage
                .getContent());
        String userId = textMessage.getUserId();
        if (StringUtils.isEmpty(userId)) {
            this.webSocketService.send(sendTM);
        } else {
            this.webSocketService.sendToUser(userId, sendTM);
        }
    }

}
