package org.loy.demo0109;

import java.util.concurrent.Semaphore;

/***
 * 信号量DEMO
 * 当存在6个线程时，但实际可进入操作的线程只能是3个，此时
 * 会进入线程等待时间，等线程释放了，其他线程可以进入
 * 信号量起到线程隔离及线程排队的作用
 *
 */
public class SemaphoreDemo {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3,true);

        for(int i=1;i<=6;i++){
            new Thread(()->{
                try {
                    // 获取锁权限
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName()+"进入");
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    // 释放锁权限
                    semaphore.release();
                    System.out.println(Thread.currentThread().getName()+"撤离");
                }
            },"线程" + i).start();
        }

    }
}
