/*
 * 深圳市Loy有限公司版权所有.
 */
package org.loy.lambda.identify;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * FunctionIdentify的使用
 *
 * @author Loy
 * @version 1.0.0
 * @date 2020/9/3
 */
public class FunctionIdentifyDemo {
    public static void main(String[] args) {
        List<LoyObject> testList = new ArrayList<>();
        LoyObject loyObject1 = new LoyObject();
        loyObject1.setLoyName("loy1");
        loyObject1.setLoyValue("loyValue1");

        LoyObject loyObject2 = new LoyObject();
        loyObject2.setLoyName("loy2");
        loyObject2.setLoyValue("loyValue2");
        testList.add(loyObject1);
        testList.add(loyObject2);

        // 两种实现方式同等效果
        Map<String,LoyObject> testMap1 = testList.stream().collect(Collectors.toMap(LoyObject::getLoyName, Function.identity()));
        Map<String,LoyObject> testMap2 = testList.stream().collect(Collectors.toMap(LoyObject::getLoyName, loyObject ->loyObject));
        System.out.println(testMap1.toString());
        System.out.println(testMap2.toString());

        // 以下如果不处理会抛重复key异常 Exception in thread "main" java.lang.IllegalStateException:
        // Duplicate key LoyObject(loyName=loy1, loyValue=loyValue1)

        LoyObject loyObject3 = new LoyObject();
        loyObject3.setLoyName("loy1");
        loyObject3.setLoyValue("loyValue3");
        testList.add(loyObject3);

        Map<String,LoyObject> testMap3 = testList.stream().collect(Collectors.toMap(LoyObject::getLoyName,
                Function.identity(), (loyKey1,loyKey2) -> loyKey2));
        System.out.println(testMap3);


    }
}
