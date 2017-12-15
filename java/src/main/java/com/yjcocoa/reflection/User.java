package com.yjcocoa.reflection;

/**
 * <p>Title: User</p>
 * <p>Description: </p>
 * <p>Create Time: 2017/12/14 下午8:51</p>
 * <p>Copyright: © 2017年 java. All rights reserved.</p>
 *
 * @author 阳君
 * @version 1.0
 */
public class User extends Base {

    public static String language = "JAVA";
    private String name;
    public String qq;

    public static User user(String name, String qq) {
        return new User(name, qq);
    }

    public User() {
    }

    public User(String name, String qq) {
        this.name = name;
        this.qq = qq;
    }

    private User(String name) { // 私有构造器
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", qq='" + qq + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    private void setName(String name) { // 私有 setter
        this.name = name;
    }


}