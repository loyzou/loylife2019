package org;

import org.junit.Test;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class MyTest01 {
    @Test
    public void test01(){
        System.out.println("test01");
    }


    @Test
    public void testCycileBarrier(){
        // 循环屏障
        CyclicBarrier cyclicBarrier = new CyclicBarrier(8);
        for(int i=1;i<=8;i++){
            new Thread(() ->{
                try {
                    // 等待线程准备
                    System.out.println(Thread.currentThread().getName() + "准备");
                    cyclicBarrier.await(); // 在屏障中进行等待
                    // 线程全部准备好
                    System.out.println("选手"+Thread.currentThread().getName()+"起跑");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }

            },"线程" + i).start();
        }
    }
}
