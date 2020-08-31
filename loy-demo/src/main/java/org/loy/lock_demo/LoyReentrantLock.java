/*
 * 深圳市Loy有限公司版权所有.
 */
package org.loy.lock_demo;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ReentrantLock 可重入锁demo
 *
 * @author Loy
 * @version 1.0.0
 * @date 2020/7/31
 */
public class LoyReentrantLock {
    public static int count = 0;
    public static ReentrantLock reentrantLock = new ReentrantLock();

    public void add() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            reentrantLock.lock();
            count++;
            System.out.println(Thread.currentThread().getName() + "计算count==" + count);
        } finally {
            reentrantLock.unlock();
        }
    }

    public void add2() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        count++;
        System.out.println(Thread.currentThread().getName() + "计算count==" + count);
    }

    public synchronized void add3() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        count++;
        System.out.println(Thread.currentThread().getName() + "计算count==" + count);
    }

    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(10000);
        long startTime = System.currentTimeMillis();
        for (int i = 0; i <10000 ; i++) {
            new Thread(() -> {
                new LoyReentrantLock().add3();
                countDownLatch.countDown();
            },"线程" + i).start();

        }

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 实际测试，ReentrantLock加锁与不加锁的耗时相差不多 ,synchronized 加锁时间要比ReentrantLock略长
        System.out.println("总计用时====================》：" + (System.currentTimeMillis() - startTime));
    }
}
