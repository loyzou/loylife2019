/*
 * 深圳市灵智数科有限公司版权所有.
 */
package org.loy.thread_demo;

import lombok.extern.slf4j.Slf4j;

/**
 * 内置同步锁demo
 *
 * <br/>
 * 结论
 *  <1> synchronized(this) ：该对象调用的不同synchronized(this)修改的方法或者代码块，是同步的。
 *                         ： 同一时间只能有一个线程能够访问该方法
 *      例如： synchronized methodA(); synchronized methodB()则会进行同步调用，先调用完A,再调用B
 *  <2> synchronized(class): 该类下的对象调用多个方法均是同步的。不管是否是同一个对象
 *
 *  <3> synchronize(自定义对象) 不同对象或同一对象访问均为同步，如果自定义对象不一样，则为异步。
 *
 * @author 邹全洪
 * @version 1.0.0
 * @date 2020/7/29
 */
@Slf4j
public class SynchronizedDemo{
    private static int count1 = 0;
    private static int count2 = 0;
    private static int count3 = 0;
    private static int count4 = 0;
    private static String lock = new String();

    /**
     * 同步方法
     */
    public synchronized void testSyncMethod() {
        log.info(Thread.currentThread().getName() + "进入方法1");
        count1++;
        log.info(Thread.currentThread().getName() + "计算count1:" + count1);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 同步代码块
     */
    public void testSyncBlock() {
        synchronized (this) {
            log.info(Thread.currentThread().getName() + "进入方法2");
            count2++;
            log.info(Thread.currentThread().getName() + "计算count2:" + count2);
        }
    }


    /**
     * 静态方法-类下的所有调用均会加锁
     */
    public static void testSyncStaticMethod() {
        synchronized (SynchronizedDemo.class) {
            log.info(Thread.currentThread().getName() + "进入方法testSyncStaticMethod");
            count3++;
            log.info("计算count3:" + count3);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 静态方法-类下的所有调用均会加锁
     */
    public static void testSyncStaticMethod2() {
        synchronized (SynchronizedDemo.class) {
            log.info(Thread.currentThread().getName() + "进入方法testSyncStaticMethod2");
            count3++;
            log.info("计算count3:" + count3);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    /**
     * 同步自定义对象
     */
    public void testSyncObject(String name) {
        synchronized (lock) {
            log.info(Thread.currentThread().getName() + "进入方法4");
            count4++;
            log.info(Thread.currentThread().getName() + "计算count4:" + count4);

            try {
                Thread.sleep(5000);
                System.out.println(Thread.currentThread().getName() + "输入的参数：" + name);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 同步自定义对象2
     */
    public void testSyncObject2(String name) {
        String lock2 = new String();
        synchronized (lock2) {
            log.info(Thread.currentThread().getName() + "testSyncObject2");
            count4++;
            try {
                Thread.sleep(5000);
                System.out.println(Thread.currentThread().getName() + "输入的参数：" + name);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }



    public static void main(String[] args) {
        SynchronizedDemo synchronizedDemo1 = new SynchronizedDemo();
        SynchronizedDemo synchronizedDemo2 = new SynchronizedDemo();

        // 测试多个实例访问非静态同步多个方法 (预期结果:异步调用不同方法)
/*        new Thread(()->{
            synchronizedDemo1.testSyncMethod();
        }).start();
        new Thread(()->{
            synchronizedDemo2.testSyncBlock();
        }).start();*/


        // 测试一个实例访问非静态同步多个方法(预期结果:同步调用不同方法 先执行方法testSyncMethod 再执行方法testSyncBlock)
       /* new Thread(()->{
            synchronizedDemo1.testSyncMethod();
        }).start();
        new Thread(()->{
            synchronizedDemo1.testSyncBlock();
        }).start();*/


        // 测试同个实例对象访问静态同步方法(预期结果:同步调用不同方法 testSyncStaticMethod 再执行方法testSyncStaticMethod2)
 /*       new Thread(()->{
            testSyncStaticMethod();
        }).start();
        new Thread(()->{
            testSyncStaticMethod2();
        }).start();*/

        // 测试不同实例对象访问静态同步方法(预期结果:同步调用不同方法 testSyncStaticMethod 再执行方法testSyncStaticMethod2)
    /*    new Thread(()->{
            synchronizedDemo1.testSyncStaticMethod();
        }).start();
        new Thread(()->{
            synchronizedDemo2.testSyncStaticMethod2();
        }).start();*/

        // 测试自定义锁对象-同一个对象访问(预期结果:同步调用方法，先执行线程1，再执行线程2))
    /*   new Thread(()->{
            synchronizedDemo1.testSyncObject("线程1");
        }).start();
        new Thread(()->{
            synchronizedDemo1.testSyncObject("线程2");
        }).start();
*/
        // 测试自定义锁对象-不同对象访问(预期结果:同步调用方法，先执行线程1，再执行线程2))
/*        new Thread(()->{
            synchronizedDemo1.testSyncObject("线程1");
        }).start();
        new Thread(()->{
            synchronizedDemo2.testSyncObject("线程2");
        }).start();*/


        // 测试自定义锁对象2-自定义不同对象(预期结果:异步调用方法))
     /*  new Thread(()->{
            synchronizedDemo1.testSyncObject2("线程1");
        }).start();
        new Thread(()->{
            synchronizedDemo1.testSyncObject2("线程2");
        }).start();*/
    }
}
