/*
 * 深圳市Loy有限公司版权所有.
 */
package org.loy.collections_demo;

import org.loy.lambda.identify.LoyObject;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 * ArrayList多个条件去重
 *
 * @author Loy
 * @version 1.0.0
 * @date 2020/9/7
 */
public class ArrayListRemoveDup {

    public static void main(String[] args) {
        LoyObject loyObject1 = new LoyObject();
        loyObject1.setLoyName("Loy1");
        loyObject1.setLoyValue("LoyVal1");

        LoyObject loyObject2 = new LoyObject();
        loyObject2.setLoyName("Loy1");
        loyObject2.setLoyValue("LoyVal1");

        LoyObject loyObject3 = new LoyObject();
        loyObject3.setLoyName("Loy1");
        loyObject3.setLoyValue("LoyVal3");

        LoyObject loyObject4 = new LoyObject();
        loyObject4.setLoyName("Loy4");
        loyObject4.setLoyValue("LoyVal1");

        List<LoyObject> list = new ArrayList<>();
        list.add(loyObject1);
        list.add(loyObject2);
        list.add(loyObject3);
        list.add(loyObject4);

        List<LoyObject> list1 = list.stream().collect(Collectors.collectingAndThen(
                Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(loy ->
                        loy.getLoyName() + ";" + loy.getLoyValue()))) , ArrayList::new));

        System.out.println("去重前：" + list.size());
        System.out.println("去重后: " + list1.size());
    }
}
