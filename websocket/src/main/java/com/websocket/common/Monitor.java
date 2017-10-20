package com.websocket.common;

import com.websocket.po.Greeting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Component
public class Monitor implements Runnable {

    @Autowired
    public SimpMessagingTemplate simpMessagingTemplate;

    @PostConstruct
    public void init() {
        ScheduledExecutorService newScheduledThreadPool = Executors.newSingleThreadScheduledExecutor();
        newScheduledThreadPool.scheduleWithFixedDelay(new Monitor(), 20, 5, TimeUnit.SECONDS);
    }

    public void run() {
        Greeting greeting = new Greeting("当前时间:" + new Date());
        System.out.println("广播发信号");
        this.simpMessagingTemplate.convertAndSend("/topic/greetings", greeting);
    }
}

