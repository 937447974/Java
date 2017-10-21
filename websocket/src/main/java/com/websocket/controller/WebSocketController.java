package com.websocket.controller;

import com.websocket.po.TextMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.stereotype.Component;
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

    @Autowired
    public SimpMessagingTemplate simpMessagingTemplate;

    @MessageMapping("/sendBroadcast")
    @SendTo("/topic/message") // 广播发送给 /topic/message 订阅客户端
    public TextMessage sendBroadcast(@Headers Map<String, Object> headers, TextMessage
            textMessage) {
        System.out.println(headers);
//        this.simpMessagingTemplate.convertAndSend("/topic/greetings", new TextMessage("阳君" + textMessage.getContent
// ()));
        this.simpMessagingTemplate.convertAndSendToUser("1", "/message", new TextMessage("定点信息"));
        return new TextMessage("阳君:" + textMessage.getContent());
    }

    /**
     * 这里用的是@SendToUser，这就是发送给单一客户端的标志。本例中，
     * 客户端接收一对一消息的主题应该是“/user/” + 用户Id + “/message” ,这里的用户id可以是一个普通的字符串，只要每个用户端都使用自己的id并且服务端知道每个用户的id就行。
     *
     * @return
     */
    @MessageMapping("/sendToUser/{userID}")
    @SendToUser("1/message")
    public TextMessage sendToUser(TextMessage textMessage) {
        System.out.println("this is the @SubscribeMapping('/marco')");
        return new TextMessage("I am a msg from SubscribeMapping('/macro').");
    }

}
