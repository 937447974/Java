package com.yjcocoa.oom;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Title: HeapOOM</p>
 * <p>Description: </p>
 * <p>Create Time: 2017/12/1 下午5:18</p>
 * <p>Copyright: © 2017年 java. All rights reserved.</p>
 *
 * @author 阳君
 * @version 1.0
 */
public class HeapOOM {

    public static void main(String[] args) {
        System.out.println("开始");
        List list = new ArrayList();
        while (true) {
            list.add(new HeapOOM());
        }
    }

}
/*
    堆溢出
    java -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError com.yjcocoa.oom.HeapOOM

    错误：
    java.lang.OutOfMemoryError: Java heap space
    Dumping heap to java_pid19833.hprof ...
    Heap dump file created [28780192 bytes in 0.134 secs]
*/