package com.websocket.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.ChannelRegistration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketTransportRegistration;

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
        registry.enableSimpleBroker("/topic", "/user");
        // 客户端向服务端发送时的主题上面需要加"/app"作为前缀
        registry.setApplicationDestinationPrefixes("/app");
        // 给指定用户发送（一对一）的主题前缀是“/user/”;
        registry.setUserDestinationPrefix("/user/");
    }

    public void registerStompEndpoints(StompEndpointRegistry stompEndpointRegistry) {
        // 设置连接点
        stompEndpointRegistry.addEndpoint("/websocket").setAllowedOrigins("*").withSockJS();
    }

    @Override
    public void configureClientInboundChannel(ChannelRegistration registration) {
        super.configureClientInboundChannel(registration);
        registration.interceptors(new WebSocketChannelInterceptor());// 设置拦截器
    }

    @Override
    public void configureWebSocketTransport(WebSocketTransportRegistration registration) {
        super.configureWebSocketTransport(registration);
        registration.setSendTimeLimit(15 * 1000) // 超时时间
                .setSendBufferSizeLimit(512 * 1024) // 缓存空间
                .setMessageSizeLimit(128 * 1024); // 消息大小
    }
}
