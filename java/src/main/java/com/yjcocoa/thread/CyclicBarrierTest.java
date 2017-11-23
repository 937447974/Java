package com.yjcocoa.thread;

import java.util.concurrent.*;

/**
 * <p>Title: CyclicBarrierTest</p>
 * <p>Description: </p>
 * <p>Create Time: 2017/11/23 下午2:01</p>
 * <p>Copyright: © 2017年 java. All rights reserved.</p>
 *
 * @author 阳君
 * @version 1.0
 */
public class CyclicBarrierTest {

    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(2);
        new Thread(() -> {
            try {
                cyclicBarrier.await(); // -1
                System.out.println("1");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
        try {
            cyclicBarrier.await(); // -1
            System.out.println("0");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}