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
    private String userID; // 用户id
    @Nullable
    private String content; // 内容

    public TextMessage() {
    }

    public TextMessage(String content) {
        this.content = content;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
