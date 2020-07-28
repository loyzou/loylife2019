/*
 * 深圳市灵智数科有限公司版权所有.
 */
package org.loy.thread_demo;

import org.mybatis.spring.annotation.MapperScan;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 生产者线程
 *
 * @author 邹全洪
 * @version 1.0.0
 * @date 2020/7/28
 */
public class ProductThreadDemo extends Thread {
    // 队列
    private List<String> taskQueue;
    // 队列最大长度
    private int maxCapacity;
    public ProductThreadDemo(List<String> taskQueue, int maxCapacity) {
        this.taskQueue = taskQueue;
        this.maxCapacity = maxCapacity;
    }

    @Override
    public void run() {
        System.out.println("生产者启动中-------》");
        int count = 0;
        while (true) {
            synchronized (taskQueue) {
                 // 生产已满
                while (taskQueue.size() == maxCapacity) {
                    // 进行等待
                    try {
                        System.out.println("队列已满等待中");
                        taskQueue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                // 进行生产
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                taskQueue.add("生产信息" + (++count));
                System.out.println("生产信息" + count);
                taskQueue.notifyAll();
            }
        }
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        int maxCapacity = 10;
        new ProductThreadDemo(list, maxCapacity).start();
        new ConsumerThreadDemo(list).start();
    }
}
