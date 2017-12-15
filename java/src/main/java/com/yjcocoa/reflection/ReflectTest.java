package com.yjcocoa.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * <p>Title: ReflectionTest</p>
 * <p>Description: </p>
 * <p>Create Time: 2017/12/14 下午8:51</p>
 * <p>Copyright: © 2017年 java. All rights reserved.</p>
 *
 * @author 阳君
 * @version 1.0
 */
public class ReflectTest {

    public static void main(String[] args) throws Exception {
//        testClass();
//        testConstructor();
//        testField();
        testMethod();
    }

    static void testClass() throws Exception {
        Class class1 = User.class;
        System.out.println(class1.getName());
        //第二种
        User demo2 = new User();
        Class c2 = demo2.getClass();
        System.out.println(c2.getName());
        //第三种
        Class class3 = Class.forName("com.yjcocoa.reflection.User");
        System.out.println(class3.getName());
    }


    static void testField() throws Exception {
        Class uc = User.class;
        // 获取所有字段
        for (Field field : uc.getDeclaredFields()) {
            System.out.println(field);
        }
        System.out.println();

        // 获取所有 public 字段，包含父类字段
        for (Field field : uc.getFields()) {
            System.out.println(field);
        }

        // private 字段 name 赋值
        Field field = uc.getDeclaredField("name");
        field.setAccessible(true);
        User user = new User();
        field.set(user, "YJ"); // set 方法
        System.out.println(user.getName() + "；" + field.get(user)); // get 方法
    }

    static void testConstructor() throws Exception {
        Class uc = User.class;
        // 获取所有构造器
        for (Constructor constructor : uc.getDeclaredConstructors()) {
            System.out.println(constructor);
        }
        System.out.println();
        // 获取所有public 构造器
        for (Constructor constructor : uc.getConstructors()) {
            System.out.println(constructor);
        }
        System.out.println();
        // private 构造器 初始化
        Constructor<User> constructor = uc.getDeclaredConstructor(String.class);
        constructor.setAccessible(true); // private 需要开启允许访问
        User user = constructor.newInstance("YJ");
        System.out.println(user);
    }

    static void testMethod() throws Exception {
        Class uc = User.class;
        // 获取所有方法
        for (Method method : uc.getDeclaredMethods()) {
            System.out.println(method);
        }
        System.out.println();
        // 获取所有 public 方法，包含父类方法
        for (Method method : uc.getMethods()) {
            System.out.println(method);
        }
        System.out.println();

        // private 方法调用
        Method method = uc.getDeclaredMethod("setName", String.class);
        method.setAccessible(true);
        User user = new User();
        method.invoke(user, "YJ");
        System.out.println(user);
    }


}