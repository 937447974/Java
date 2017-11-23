import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.*;


/**
 * <p>Title: JavaTest</p>
 * <p>Description: </p>
 * <p>Create Time: 2017/11/6 下午3:06</p>
 * <p>Copyright: © 2017年 java. All rights reserved.</p>
 *
 * @author 阳君
 * @version 1.0
 */
public class JavaTest {
    final String c = "";

    @Test
    public void test() {
//        Integer i = 0;
//        while (true) {
//            i = 1;
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            public void run() {
                System.out.println("1" + new Date());
            }
        };
        timer.schedule(task, 1, 1);
        System.out.println("2");
    }

    public static void main(String[] args) {
        Timer timer = new Timer();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        TimerTask task = new TimerTask() {
            public void run() {
                System.out.println("0" + formatter.format(new Date()));
                System.out.println(Thread.currentThread());
            }
        };
        System.out.println(formatter.format(new Date()));
//        timer.schedule(task, 0, 10000L);
        ScheduledThreadPoolExecutor pool = new ScheduledThreadPoolExecutor(5);
        System.out.println(formatter.format(new Date()));
        pool.schedule(() -> {
            System.out.println("1" + formatter.format(new Date()));
            System.out.println(Thread.currentThread());
        }, 5, TimeUnit.SECONDS);
        System.out.println("3");
        pool.schedule(() -> {
            System.out.println("2" + formatter.format(new Date()));
            System.out.println(Thread.currentThread());
        }, 5, TimeUnit.SECONDS);
        System.out.println("2");
        pool.shutdown();
        System.out.println("1");
        System.out.println(formatter.format(new Date()));
//        timer.schedule (task, 0, 1000L);
        FutureTask task1;

    }

    // 第一种方法：设定指定任务task在指定时间time执行 schedule(TimerTask task, Date time)
    public static void timer1() {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            public void run() {
                System.out.println("-------设定要指定任务--------");
            }
        }, 2000);// 设定指定的时间time,此处为2000毫秒
    }

}

