/*
 * 深圳市Loy有限公司版权所有.
 */
package org.loy.thread_demo;

/**
 * 通过监听是否中断的方式，进行中断
 *
 * @author Loy
 * @version 1.0.0
 * @date 2020/7/28
 */
public class InterruptedDemo2 extends Thread {
    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            System.out.println("进行正常操作");
        }

        System.out.println("。。。。。中断操作完成。。。");

    }

    public static void main(String[] args) {
        InterruptedDemo2 interruptedDemo2 = new InterruptedDemo2();
        interruptedDemo2.start();

        try {
            Thread.sleep(10000);
            System.out.println("进行中断中。。。。");
            interruptedDemo2.interrupt();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
