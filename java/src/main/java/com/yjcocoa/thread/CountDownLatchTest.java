package com.yjcocoa.thread;

import java.util.concurrent.CountDownLatch;

/**
 * <p>Title: CountDownLatchTest</p>
 * <p>Description: </p>
 * <p>Create Time: 2017/11/22 下午9:21</p>
 * <p>Copyright: © 2017年 java. All rights reserved.</p>
 *
 * @author 阳君
 * @version 1.0
 */
public class CountDownLatchTest {


    public static void main(String[] args) {
        CountDownLatch latch = new CountDownLatch(2);
        new Thread(() -> {
            try {
                latch.await();
                System.out.println("1");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        latch.countDown(); //-1
        System.out.println("0");
        latch.countDown(); // -1, 此时计数器为0，await线程恢复执行
    }

}