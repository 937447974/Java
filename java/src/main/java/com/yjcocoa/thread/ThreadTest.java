package com.yjcocoa.thread;

/**
 * <p>Title: ThreadTest</p>
 * <p>Description: </p>
 * <p>Create Time: 2017/11/22 下午3:38</p>
 * <p>Copyright: © 2017年 java. All rights reserved.</p>
 *
 * @author 阳君
 * @version 1.0
 */
public class ThreadTest {

    public static void main(String[] args) {
        System.out.println(Thread.currentThread());
        Thread thread = new Thread(() -> {
            // 执行任务
        });
        thread.start();
    }

}