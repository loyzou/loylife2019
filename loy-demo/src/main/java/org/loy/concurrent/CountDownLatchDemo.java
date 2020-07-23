package org.loy.concurrent;

import java.util.concurrent.CountDownLatch;

/***
 * CountDownLatchDemo
 * 等待某些线程执行完毕，才执行主线程或其他线程的操作
 */
public class CountDownLatchDemo {
    public static void main(String[] args) {
        /*
            此处设置处理50个线程，当实际线程大于50时，只要50个线程操作完成
            即会继续执行主线程或其他线程
         */
        CountDownLatch countDownLatch = new CountDownLatch(50);

        for(int i=1;i<=50;i++){
            new Thread(() ->{
                System.out.println(Thread.currentThread().getName() + "执行了");
                countDownLatch.countDown();

            },"线程" + i).start();
        }

        // 线程进入等待
        try {
            System.out.println("等待线程执行");
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("线程全部执行完毕");


        CountDownLatch countDownLatch2 = new CountDownLatch(50);

        for(int i=1;i<=60;i++){
            new Thread(() ->{
                System.out.println(Thread.currentThread().getName() + "执行了");
                countDownLatch2.countDown();

            },"线程" + i).start();
        }

        // 线程进入等待
        try {
            System.out.println("等待线程执行");
            countDownLatch2.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("50个线程执行完毕");
    }
}
