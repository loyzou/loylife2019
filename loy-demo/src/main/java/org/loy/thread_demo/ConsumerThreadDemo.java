/*
 * 深圳市Loy有限公司版权所有.
 */
package org.loy.thread_demo;

import java.util.List;

/**
 * 消费者线程
 *
 * @author Loy
 * @version 1.0.0
 * @date 2020/7/24
 */
public class ConsumerThreadDemo extends Thread {
    // 公共传入对象，用于监视
    private List<String> taskQueue;
    public ConsumerThreadDemo(List<String> taskQueue) {
        this.taskQueue = taskQueue;
    }

    @Override
    public void run() {
        System.out.println("消费者启动中-------》");
        while (true) {
            synchronized (taskQueue) {
                while (taskQueue.isEmpty()) {
                    // 没有队列可以消费进行等待
                    System.out.println("没有队列可以消费进行等待");
                    try {
                        taskQueue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                // 进行消费第0个
                String content = taskQueue.remove(0);
                System.out.println("消费队列消费了====>" + content);
                taskQueue.notifyAll();

            }
        }

    }
}
