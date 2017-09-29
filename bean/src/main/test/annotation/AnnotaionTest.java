package annotation;

import com.bean.annotation.AnnotationT;
import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * AnnotaionTest.java
 * <p>
 * Created by didi on 2017/9/29.
 * Copyright © 2017年 bean. All rights reserved.
 */
public class AnnotaionTest {

    public <T> T getBean(Class<T> requiredType) throws Exception {
        // 类注解
        for (Annotation annotaion : requiredType.getDeclaredAnnotations()) {
            System.out.println(annotaion + " / 类：" + requiredType);
        }
        // 类乘员变量注解
        for (Field field : requiredType.getFields()) {
            if (field.isAnnotationPresent(AnnotationT.class)) {
                AnnotationT a = (AnnotationT) field.getAnnotation(AnnotationT.class);
                System.out.println(a + " / 修饰符：" + Modifier.toString(field.getModifiers()) + "；类型：" + field.getType() +
                        "名称：" + field.getName());
            }
        }
        // 构造方法注解
        for (Constructor method : requiredType.getConstructors()) {
            if (method.isAnnotationPresent(AnnotationT.class)) {
                AnnotationT a = (AnnotationT) method.getAnnotation(AnnotationT.class);
                System.out.println(a + " / " + method.getName());
            }
        }
        // 类方法注解
        for (Method method : requiredType.getDeclaredMethods()) {
            if (method.isAnnotationPresent(AnnotationT.class)) {
                AnnotationT a = (AnnotationT) method.getAnnotation(AnnotationT.class);
                System.out.println(a + " / 方法名称：" + method.getName());
                int index = 0;
                Class<?>[] parameterTypes = method.getParameterTypes();
                for (Annotation[] tt : method.getParameterAnnotations()) {
                    for (Annotation t : tt) {
                        System.out.println(t + " / 参数" + index + "；类型" + parameterTypes[index]);
                    }
                    index++;
                }
            }
        }
        return null;
    }

    @Test
    public void test() throws Exception {
        this.getBean(UserAnnotation.class);

    }
}
