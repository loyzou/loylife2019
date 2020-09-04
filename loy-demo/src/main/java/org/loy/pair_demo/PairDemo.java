/*
 * 深圳市Loy有限公司版权所有.
 */
package org.loy.pair_demo;

import javafx.util.Pair;

/**
 * 返回值对Demo
 *
 * @author Loy
 * @version 1.0.0
 * @date 2020/9/4
 */
public class PairDemo {
    public Pair<LoyPairOne,LoyPairTwo> getLoyPairTest() {
        LoyPairOne loyPairOne = new LoyPairOne();
        loyPairOne.setKey("loy");

        LoyPairTwo loyPairTwo = new LoyPairTwo();
        loyPairTwo.setValue("loyValue");

        return new Pair<>(loyPairOne, loyPairTwo);
    }
    public static void main(String[] args) {
        Pair pair = new PairDemo().getLoyPairTest();
        System.out.println(pair.getKey());
        System.out.println(pair.getValue());
    }
}
