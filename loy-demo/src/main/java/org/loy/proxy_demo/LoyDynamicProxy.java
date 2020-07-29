/*
 * 深圳市灵智数科有限公司版权所有.
 */
package org.loy.proxy_demo;

import com.sun.deploy.net.proxy.DynamicProxyManager;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理
 *
 * @author 邹全洪
 * @version 1.0.0
 * @date 2020/7/29
 */
public class LoyDynamicProxy implements InvocationHandler {
    private Object targetObject;

    public LoyDynamicProxy(Object targetObject) {
        this.targetObject = targetObject;
    }

    public <T>T getProxy() {
        return (T)Proxy.newProxyInstance(targetObject.getClass().getClassLoader(),targetObject.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Do something before");
            Object result = method.invoke(targetObject, args);
        System.out.println("Do something after");
        return result;
    }

    public static void main(String[] args) {
        // 输出代理类的源文件
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        LoyDynamicProxy loyDynamicProxy = new LoyDynamicProxy(new LoyProxyClass());
        ILoyProxy iLoyProxy = loyDynamicProxy.getProxy();
        String show = iLoyProxy.show();
        System.out.println("返回结果:" + show);

        LoyDynamicProxy loyDynamicProxy2 = new LoyDynamicProxy(new LoyProxyClass2());
        ILoyProxy iLoyProxy2 = loyDynamicProxy2.getProxy();
        String show2 = iLoyProxy2.show();
        System.out.println("返回结果:" + show2);
    }
}
