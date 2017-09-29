package annotation;

import java.lang.annotation.*;

/**
 * AnnotationT.java
 * <p>
 * Created by didi on 2017/9/29.
 * Copyright © 2017年 bean. All rights reserved.
 */
@Target({ElementType.TYPE, ElementType.CONSTRUCTOR, ElementType.METHOD, ElementType.PARAMETER, ElementType.FIELD,
        ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface AnnotationT {
    String value() default "";
}