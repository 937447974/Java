package com.yjcocoa.thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * <p>Title: LockTest</p>
 * <p>Description: </p>
 * <p>Create Time: 2017/11/22 下午4:56</p>
 * <p>Copyright: © 2017年 java. All rights reserved.</p>
 *
 * @author 阳君
 * @version 1.0
 */
public class LockTest {

    private final Lock lock = new ReentrantLock();

    public void test() {

        lock.lock(); // 加锁
        try {

        } finally {
            lock.unlock(); // 解锁
        }

        if (lock.tryLock()) { // 试加锁，加锁失败立即返回false 不会等待
            try {
                // manipulate protected state
            } finally {
                lock.unlock();
            }
        } else {
            // perform alternative actions
            System.out.println("1");
        }

        try {
            if (lock.tryLock(1, TimeUnit.SECONDS)) { // 1秒内加锁，超时会返回false
                try {
                    // manipulate protected state
                } finally {
                    lock.unlock();
                }
            } else {
                // perform alternative actions
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

    }


}