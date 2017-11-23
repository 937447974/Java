package com.yjcocoa.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * <p>Title: ReadWriteLockTest</p>
 * <p>Description: </p>
 * <p>Create Time: 2017/11/22 下午6:08</p>
 * <p>Copyright: © 2017年 java. All rights reserved.</p>
 *
 * @author 阳君
 * @version 1.0
 */
public class ReadWriteLockTest {

    private final ReadWriteLock rwLock = new ReentrantReadWriteLock();
    private final Lock readLock = rwLock.readLock();
    private final Lock writeLock = rwLock.writeLock();

    public void read () {
        readLock.lock();
        try {
        } finally {
            readLock.unlock();
        }
    }

    public void write () {
        writeLock.lock();
        try {
        } finally {
            writeLock.unlock();
        }
    }

}