package com.websocket.po;

import org.springframework.lang.Nullable;

/**
 * TextMessage.java
 * <p>
 * Created by 阳君 on 2017/10/21.
 * Copyright © 2017年 websocket. All rights reserved.
 */
public class TextMessage {

    @Nullable
    private String userId; // 用户id
    @Nullable
    private String content; // 内容

    public TextMessage() {
    }

    public TextMessage(String content) {
        this.content = content;
    }

    @Nullable
    public String getUserId() {
        return userId;
    }

    @Nullable
    public String getContent() {
        return content;
    }
}
