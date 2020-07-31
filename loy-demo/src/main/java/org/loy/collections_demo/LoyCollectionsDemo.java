/*
 * 深圳市Loy有限公司版权所有.
 */
package org.loy.collections_demo;

import lombok.extern.slf4j.Slf4j;

import java.util.Collections;
import java.util.List;

/**
 * CollectionsDemo
 * Collections.singletonList()场景适用于单个值转换成数组
 * 与Arrays.toList()的区别在于Arrays.toList()可以进行操作，且可以多参。
 *
 * @author Loy
 * @version 1.0.0
 * @date 2020/7/30
 */
@Slf4j
public class LoyCollectionsDemo {
    public static void main(String[] args) {
        String loy = "loy";
        // 将字符串转成成数组
        List<String> loyList = Collections.singletonList(loy);
        log.info(loyList.toString());

        // 不能进行操作，否则会抛UnsupportedOperationException异常
        //loyList.add("test");

    }
}
