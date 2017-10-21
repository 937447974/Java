package com.websocket.config;

import com.websocket.component.WebSocketPool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.ChannelInterceptorAdapter;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketSession;

/**
 * InboundChannelInterceptor.java
 * 输入通道拦截器
 * Created by 阳君 on 2017/10/21.
 * Copyright © 2017年 websocket. All rights reserved.
 */
@Component
public class InboundChannelInterceptor extends ChannelInterceptorAdapter {

    @Autowired
    private WebSocketPool webSocketPool;

    @Override
    public Message<?> preSend(Message<?> message, MessageChannel channel) {
        System.out.println("preSend:" + message.getHeaders());
        return super.preSend(message, channel);
    }

    @Override
    public void postSend(Message<?> message, MessageChannel channel, boolean sent) {
        System.out.println("postSend输入数据处理后");
        super.postSend(message, channel, sent);
    }

    @Override
    public void afterSendCompletion(Message<?> message, MessageChannel channel, boolean sent, @Nullable Exception ex) {
        super.afterSendCompletion(message, channel, sent, ex);
        System.out.println("afterSendCompletion");
    }
}
