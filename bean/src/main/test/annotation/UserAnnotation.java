package annotation;


/**
 * UserAnnotation.java
 * <p>
 * Created by didi on 2017/9/29.
 * Copyright © 2017年 bean. All rights reserved.
 */
@AnnotationT(value = "类注解")
public class UserAnnotation extends UserAnnotationBase {

    @AnnotationT(value = "成员变量注解")
    public String str;

    @AnnotationT(value = "构造方法注解")
    public UserAnnotation() {
    }

    @AnnotationT(value = "类方法注解")
    public void test(String str1, @AnnotationT(value = "方法参数注解") String str) {
    }

}
