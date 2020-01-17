package org.loy.demo0114;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.ReentrantLock;

public class RedisLockDemo {
    private static int num = 10;
    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(100);


        for(int i=1;i <=100;i++){
            new Thread(()->{
                countDownLatch.countDown();
                try {
                    countDownLatch.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                // 进行库存扣减操作
                if(num >0){
                    doReduce();
                }else{
                    noStock();
                }
            },"线程" + i).start();
        }
    }

    private static void noStock(){
        System.out.println(Thread.currentThread().getName() + "no Stock" + num);
    }

    private static void doReduce(){
        num--;
        System.out.println(Thread.currentThread().getName() + "doReduce After" + num);
        ReentrantLock lock = new ReentrantLock();
        lock.lock();
        lock.unlock();
    }
}
