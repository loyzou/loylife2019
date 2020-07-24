/*
 * 深圳市灵智数科有限公司版权所有.
 */
package org.loy.thread_demo;

/**
 * Class类直接waitDemo
 *
 * @author 邹全洪
 * @version 1.0.0
 * @date 2020/7/24
 */
public class ClassWaitDemo {
    public static void main(String[] args) {

        long startTime = System.currentTimeMillis();
        try {
            // 此处必须加synchronize，否则会抛异常 IllegalMonitorStateException
            synchronized (ClassWaitDemo.class) {
                ClassWaitDemo.class.wait(10000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        System.out.println("class wait demo" + (System.currentTimeMillis() - startTime));
    }
}
