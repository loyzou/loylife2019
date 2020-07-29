/*
 * 深圳市灵智数科有限公司版权所有.
 */
package org.loy.thread_demo;

/**
 * 中断demo
 *
 * @author 邹全洪
 * @version 1.0.0
 * @date 2020/7/28
 */
public class InterruptedDemo1 extends Thread {
    private static volatile boolean isInterrupted = false;

    @Override
    public void run() {

        while (!isInterrupted) {
            System.out.println("线程执行中。。。。。。");
            Thread.yield();
        }
        System.out.println("线程中断");

    }

    public static void main(String[] args) {
        InterruptedDemo1 interruptedDemo1 = new InterruptedDemo1();
        interruptedDemo1.start();

        // 中断线程
        try {
            Thread.sleep(5000);
            isInterrupted = true;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
