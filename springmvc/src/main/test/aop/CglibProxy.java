package aop;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * CglibProxy.java
 * <p>
 * Created by 阳君 on 2017/10/18.
 * Copyright © 2017年 springmvc. All rights reserved.
 */
public class CglibProxy implements MethodInterceptor {

    // 创建代理方法
    public Object createProxy(Class targetClass) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(targetClass);
        enhancer.setCallback(this);
        return enhancer.create();
    }

    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        MyAspect myAspect = new MyAspect();
        myAspect.before();
        Object object = methodProxy.invokeSuper(o, objects);
        myAspect.after();
        return object;
    }
}
