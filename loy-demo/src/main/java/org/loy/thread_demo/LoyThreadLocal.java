/*
 * 深圳市灵智数科有限公司版权所有.
 */
package org.loy.thread_demo;

import java.util.HashMap;
import java.util.Map;

/**
 * ThreadLocalDemo
 *
 * @author 邹全洪
 * @version 1.0.0
 * @date 2020/7/28
 */
public class LoyThreadLocal extends ThreadLocal{
    private static ThreadLocal<Map<String,String>> loyLocal = new ThreadLocal<>();

    public static void main(String[] args) {
        new Thread(()-> {
            Map<String,String> loyMap1 = new HashMap<>();
            loyMap1.put("loy", "loy1");
            loyLocal.set(loyMap1);

            // 获取当前线程下的map
            System.out.println(Thread.currentThread().getName()+":" + loyLocal.get().get("loy"));


        }).start();
        new Thread(()-> {
            Map<String,String> loyMap2 = new HashMap<>();
            loyMap2.put("loy", "loy2");
            loyLocal.set(loyMap2);

            // 获取当前线程下的map
            System.out.println(Thread.currentThread().getName() + ":" + loyLocal.get().get("loy"));

        }).start();
    }
}
