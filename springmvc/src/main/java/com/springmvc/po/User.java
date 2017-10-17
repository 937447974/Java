package com.springmvc.po;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

/**
 * 用户POJO
 */
public class User {

    @NotEmpty(message = "{username.NotEmpty}")
    private String username;

    @NotEmpty(message = "{password.NotEmpty}")
    @Size(min = 6, max = 9, message = "{password.Size}")
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User [username=" + username + ", password=" + password + "]";
    }
}
