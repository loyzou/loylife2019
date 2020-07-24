/*
 * 深圳市灵智数科有限公司版权所有.
 */
package org.loy.thread_demo;

/**
 * 线程类的方式，等待demo
 *
 * @author 邹全洪
 * @version 1.0.0
 * @date 2020/7/24
 */
public class ThreadWaitDemo extends Thread {

    @Override
    public synchronized  void run() {
        long startTime = System.currentTimeMillis();
        try {
            this.wait(10000);
            System.out.println("thread wait demo" + (System.currentTimeMillis() - startTime));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new ThreadWaitDemo().start();
    }
}
