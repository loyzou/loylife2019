/*
 * 深圳市灵智数科有限公司版权所有.
 */
package org.loy.proxy_demo;

/**
 * 原代理对象2
 *
 * @author 邹全洪
 * @version 1.0.0
 * @date 2020/7/29
 */
public class LoyProxyClass2 implements ILoyProxy{
    @Override
    public String show() {
        System.out.println("动态代理对象2");
        return "动态代理对象2";
    }
}
