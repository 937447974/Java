package com.websocket.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

/**
 * WebsocketConfig.java
 * <p>
 * Created by 阳君 on 2017/10/20.
 * Copyright © 2017年 websocket. All rights reserved.
 */
@Configuration
@EnableWebSocketMessageBroker
public class WebsocketConfig extends AbstractWebSocketMessageBrokerConfigurer {

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        super.configureMessageBroker(registry);
        // 在topic和user这两个域上可以向客户端发消息；
        registry.enableSimpleBroker("/topic","/user");
        // 客户端向服务端发送时的主题上面需要加"/app"作为前缀
        registry.setApplicationDestinationPrefixes("/app");
        // 给指定用户发送（一对一）的主题前缀是“/user/”;
        registry.setUserDestinationPrefix("/user/");
    }

    public void registerStompEndpoints(StompEndpointRegistry stompEndpointRegistry) {
        stompEndpointRegistry.addEndpoint("/hello").setAllowedOrigins("*").withSockJS();
    }
}
