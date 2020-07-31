/*
 * 深圳市Loy有限公司版权所有.
 */
package org.loy.proxy_demo;

/**
 * 被代理的对象
 *
 * @author Loy
 * @version 1.0.0
 * @date 2020/7/29
 */
public class LoyProxyClass implements ILoyProxy{
    @Override
    public String show() {
        System.out.println("LoyProxyClass");
        return "LoyProxyClass";
    }
}
