package aop;

/**
 * MyAspect.java
 * <p>
 * Created by 阳君 on 2017/10/18.
 * Copyright © 2017年 springmvc. All rights reserved.
 */
public class MyAspect {
    public void before() {
        System.out.println("MyAspect.before");
    }

    void after() {
        System.out.println("MyAspect.after");
    }
}
