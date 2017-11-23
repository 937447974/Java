package com.yjcocoa.thread;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimerTask;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * <p>Title: ScheduledThreadPoolExecutorTest</p>
 * <p>Description: </p>
 * <p>Create Time: 2017/11/23 下午3:08</p>
 * <p>Copyright: © 2017年 java. All rights reserved.</p>
 *
 * @author 阳君
 * @version 1.0
 */
public class ScheduledThreadPoolExecutorTest {

    public static void main(String[] args) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        ScheduledThreadPoolExecutor pool = new ScheduledThreadPoolExecutor(5);
        pool.schedule(() -> { // 延时5秒执行
            System.out.println("1-" + formatter.format(new Date()));
        }, 5, TimeUnit.SECONDS);
        pool.scheduleAtFixedRate(() -> { // 延迟2秒后周期1秒执行任务
            System.out.println("2-" + formatter.format(new Date()));
        }, 2,1, TimeUnit.SECONDS);
        System.out.println("开始-" + formatter.format(new Date()));
    }

}