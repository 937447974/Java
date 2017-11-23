package com.yjcocoa.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * <p>Title: ConditionTest</p>
 * <p>Description: </p>
 * <p>Create Time: 2017/11/22 下午6:00</p>
 * <p>Copyright: © 2017年 java. All rights reserved.</p>
 *
 * @author 阳君
 * @version 1.0
 */
public class ConditionTest {

    private final Lock lock = new ReentrantLock();
    private final Condition condition1 = lock.newCondition();
    private final Condition condition2 = lock.newCondition();


    public void test() {
        lock.lock();
        try {
//            while (保护条件1) {
//                condition1.await();
//            }
//            while (保护条件2) {
//                condition2.await();
//            }
            condition1.notifyAll();// 激活条件1的线程
        } finally {
          lock.unlock();
        }
    }

}