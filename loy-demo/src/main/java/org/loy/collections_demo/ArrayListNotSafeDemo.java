/*
 * 深圳市灵智数科有限公司版权所有.
 */
package org.loy.collections_demo;

import java.util.ArrayList;
import java.util.List;

/**
 * ArrayList线程不安全demo
 * 出现原因：
 * (1) 当两个线程在判断是够扩容时，均发现不用扩容，于是A线程添加到数组最大值时，可以正常添加，B线程添加时，由于没有扩容，导致数组越界
 * (2) 当两个线程添加数组某一位置时，由于elementData[size++] 操作非原子性，会导致覆盖问题
 * 线程安全方案：
 * (1) CopyOnWriteArrayList 适合读多写好，因为当有大量写的时候，每次都需要复制一个数组，会造成性能下降
 * (2) Collections.synchronizeList(); 底层原理实际上就是加锁操作
 *
 * @author 邹全洪
 * @version 1.0.0
 * @date 2020/8/31
 */
public class ArrayListNotSafeDemo {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

        new Thread(() -> {
            for (int i = 0; i <1000 ; i++) {
                list.add(String.valueOf(i));
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(() -> {
            for (int i = 1000; i <2000 ; i++) {
                list.add(String.valueOf(i));
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < list.size(); i++) {
            System.out.println("第" + (i + 1) + "个元素为：" + list.get(i));
        }
    }
}
