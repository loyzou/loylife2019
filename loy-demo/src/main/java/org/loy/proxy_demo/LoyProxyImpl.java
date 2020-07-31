/*
 * 深圳市Loy有限公司版权所有.
 */
package org.loy.proxy_demo;

/**
 * 静态代理实现类
 *
 * @author Loy
 * @version 1.0.0
 * @date 2020/7/29
 */
public class LoyProxyImpl implements ILoyProxy {
    private LoyProxyClass loyProxyClass;
    public LoyProxyImpl(LoyProxyClass loyProxyClass) {
        this.loyProxyClass = loyProxyClass;
    }

    @Override
    public String show() {
        return loyProxyClass.show();
    }

    public static void main(String[] args) {
        ILoyProxy loyProxy = new LoyProxyImpl(new LoyProxyClass());
        loyProxy.show();
    }
}
