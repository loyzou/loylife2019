/*
 * 深圳市Loy有限公司版权所有.
 */
package org.loy.collections_demo;

import java.util.Arrays;
import java.util.List;

/**
 * Arrays.asList() demo
 *
 *
 * @author 邹全洪
 * @version 1.0.0
 * @date 2020/8/3
 */
public class LoyArraysDemo {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3);
        System.out.println(list);
//      此处不能进行加入操作 UnsupportedOperationException
//      list.add(4);
//      System.out.println(list);
    }
}
