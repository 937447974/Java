package com.yjcocoa.oom;


//import sun.misc.Unsafe;

//import jdk.internal.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * <p>Title: DirectMemoryOOM</p>
 * <p>Description: </p>
 * <p>Create Time: 2017/12/3 下午3:31</p>
 * <p>Copyright: © 2017年 java. All rights reserved.</p>
 *
 * @author 阳君
 * @version 1.0
 */
public class DirectMemoryOOM {

    private static final int _1MB = 1024 * 1024;

    public static void main(String[] args) throws Exception {
//        Field unsafeField = Unsafe.class.getDeclaredFields()[0];
//        unsafeField.setAccessible(true);
//        Unsafe unsafe = (Unsafe) unsafeField.get(null);
//        while (true) {
//            unsafe.allocateMemory(_1MB);
//        }
    }

}
/*
 本机直接内存溢出
    java -Xms20m -Xmx20m -XX:MaxDirectMemorySize=10M com.yjcocoa.oom.DirectMemoryOOM

 */