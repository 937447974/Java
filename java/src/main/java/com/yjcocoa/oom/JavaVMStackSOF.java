package com.yjcocoa.oom;

/**
 * <p>Title: JavaVMStackSOF</p>
 * <p>Description: </p>
 * <p>Create Time: 2017/12/1 下午5:35</p>
 * <p>Copyright: © 2017年 java. All rights reserved.</p>
 *
 * @author 阳君
 * @version 1.0
 */
public class JavaVMStackSOF {

    public void stackLeak() {
        this.stackLeak();
    }

    public static void main(String[] args) {
        new JavaVMStackSOF().stackLeak();
    }

}

/*
    虚拟机栈和本地方法栈溢出
    java -Xss256k com.yjcocoa.oom.JavaVMStackSOF

    输出：
    Exception in thread "main" java.lang.StackOverflowError
*/