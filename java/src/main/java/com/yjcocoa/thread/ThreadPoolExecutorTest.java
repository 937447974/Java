package com.yjcocoa.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * <p>Title: ThreadPoolExecutorTest</p>
 * <p>Description: </p>
 * <p>Create Time: 2017/11/23 下午2:26</p>
 * <p>Copyright: © 2017年 java. All rights reserved.</p>
 *
 * @author 阳君
 * @version 1.0
 */
public class ThreadPoolExecutorTest {

    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 2, 4, TimeUnit.SECONDS, new
                ArrayBlockingQueue<Runnable>(100));
        // 添加任务
        Future<String> future = threadPoolExecutor.submit(() -> {
            Thread.sleep(5000);
            return "YJ";
        });
        // 获取线程返回结果
        try {
            System.out.println(future.get()); // 堵塞当前线程等待目标线程返回结果
        } catch (Exception e) {
            e.printStackTrace();
        }
        threadPoolExecutor.shutdownNow();

    }

}