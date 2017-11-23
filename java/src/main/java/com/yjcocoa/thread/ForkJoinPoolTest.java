package com.yjcocoa.thread;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 * <p>Title: ForkJoinPoolTest</p>
 * <p>Description: </p>
 * <p>Create Time: 2017/11/23 下午3:20</p>
 * <p>Copyright: © 2017年 java. All rights reserved.</p>
 *
 * @author 阳君
 * @version 1.0
 */
public class ForkJoinPoolTest {

    private final ForkJoinPool pool = new ForkJoinPool();

    public void quickSort(List<Integer> list) {
        if (list == null || list.size() <= 1)
            return;
        try {
            pool.submit(() -> { // 提交总任务
                quiceSort(list, 0, list.size() - 1);
            }).get();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void quiceSort(List<Integer> list, int start, int end) {
        if (start >= end)
            return;
        int index = this.partition(list, start, end);
        if (end - start >= 10) { // 拆分子任务
            ForkJoinTask left = new RecursiveTask() {
                protected Object compute() {
                    quiceSort(list, start, index - 1);
                    return null;
                }
            };
            left.fork();
            ForkJoinTask right = new RecursiveTask() {
                protected Object compute() {
                    quiceSort(list, index + 1, end);
                    return null;
                }
            };
            right.fork();
            left.join();
            right.join();
        } else {
            quiceSort(list, start, index - 1);
            quiceSort(list, index + 1, end);
        }
    }

    private int partition(List<Integer> list, int start, int end) {
        int index = start;
        int last = list.get(end);
        for (int i = start; i < end; i++) {
            if (list.get(i) <= last) {
                this.exchange(list, index, i);
                index++;
            }
        }
        this.exchange(list, index, end);
        return index;
    }

    private void exchange(List<Integer> list, int start, int end) {
        if (start == end)
            return;
        int temp = list.get(start);
        list.set(start, list.get(end));
        list.set(end, temp);
    }

    public static void main(String[] args) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(formatter.format(new Date()));
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10000000; i++) {
            list.add((int) (Math.random() * 1000000));
        }
        ForkJoinPoolTest test = new ForkJoinPoolTest();
        test.quickSort(list);
        System.out.println(formatter.format(new Date()));
        for (int i = 0; i < list.size() - 2; i++) {
            if (list.get(i) > list.get(i+1)) {
                System.out.println("排序失败");
            }
        }
        System.out.println(formatter.format(new Date()));
    }

}