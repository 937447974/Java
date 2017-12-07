package com.yjcocoa.oom;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>Title: RuntimeConstantPoolOOM</p>
 * <p>Description: </p>
 * <p>Create Time: 2017/12/1 下午7:00</p>
 * <p>Copyright: © 2017年 java. All rights reserved.</p>
 *
 * @author 阳君
 * @version 1.0
 */
public class RuntimeConstantPoolOOM {



    public static void main(String[] args) throws Exception {
        List list = new ArrayList();
        int i = 0;
        while (true) {
            Thread.sleep(1);
            list = (List) Class.forName("java.util.ArrayList").getDeclaredConstructor().newInstance();
            list.add(String.valueOf(i++).intern());
        }
    }
}

/*
运行时常量池导致的内存溢出异常
java -XX:MetaspaceSize=10M -XX:MaxMetaspaceSize=10M com.yjcocoa.oom.RuntimeConstantPoolOOM
 */