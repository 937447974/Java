package aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * JDKProxy.java
 * <p>
 * Created by 阳君 on 2017/10/18.
 * Copyright © 2017年 springmvc. All rights reserved.
 */
public class JDKProxy implements InvocationHandler {

    private Object target;// 目标类

    // 创建代理方法
    public Object createProxy(Object target) {
        this.target = target;
        ClassLoader classLoader = JDKProxy.class.getClassLoader();
        Class[] interfaces = target.getClass().getInterfaces();
        return Proxy.newProxyInstance(classLoader, interfaces, this);
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 切面
        MyAspect myAspect = new MyAspect();
        myAspect.before();
        Object object = method.invoke(this.target, args);
        myAspect.after();
        return object;
    }
}
