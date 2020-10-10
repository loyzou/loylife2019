/*
 * 深圳市Loy有限公司版权所有.
 */
package org.loy.leetcode_demo;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 两个数相加获取等于目标值得数组下标
 *
 * @author Loy
 * @version 1.0.0
 * @date 2020/8/3
 */
public class TwoSumDemo {
    public static int[] arrays = new int[]{2,3,5,8,6,11,9};

    public static int[] testSum(int targetNum) {
        // 原理说明
        // 前面的数值 都需要匹配预期的值，而前部分因为预期的值尚未加入map中，所以匹配不到
        // 而当后面的值加入map中时，也需要匹配预期值，而此时前面的值已经加入到map中，所以可以获取得到
        // 例如 index = 1 时 ，此时当前的值为3，目标值为11 则预期获取的值为8，此时8的值尚未加入到map中，所以获取不到
        // 而当 index = 3 时 ，此时当前的值为8，目标值为11 则预期获取的值为3，此时3的值之前已经加入到map中，所以可以获取到对象的值


        int[] index = new int[]{0,0};
        Map<Integer, Integer> resultMap = new HashMap<>();
        for (int i = 0; i < arrays.length; i++) {
            // 设置当前的值相加的目标值等于最终目标值
            resultMap.put(arrays[i], i);
            int num = targetNum - arrays[i];

            // 说明存在该值
            if (resultMap.get(num) != null) {
                index[0] = resultMap.get(num);
                index[1] = i;
                return index;
            }
        }

        return index;
    }

    public static void main(String[] args) {
        int[] index = testSum(11);
        System.out.println(Arrays.toString(index));
    }
}
