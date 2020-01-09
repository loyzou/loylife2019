package org.loy.util;

public class ThreadLocalTest {
    private static ThreadLocal<String> threadLocal = new ThreadLocal<>();
    public static void main(String[] args) {
        Thread t1 = new Thread(()->{
            threadLocal.set("test1");
            System.out.println(threadLocal.get());
        });

        Thread t2 = new Thread(()->{
            threadLocal.set("test2");
            System.out.println(threadLocal.get());
        });

        t1.start();
        t2.start();

    }
}
