/*
 * 深圳市灵智数科有限公司版权所有.
 */
package org.loy.handlerchain_demo;

/**
 *
 * 责任链模式
 * 责任链模式为：如果自己能处理则自己处理，否则交给转交对象处理
 *
 * @author 邹全洪
 * @version 1.0.0
 * @date 2020/7/28
 */
public abstract class LoyHandler {
    private LoyHandler nextHandler;
    public void setNextHandler(LoyHandler loyHandler) {
        this.nextHandler = loyHandler;
    }

    public abstract int getLevel();

    public abstract String doHandler(int level);

    public void handler(int level) {
        if (level == getLevel()) {
            System.out.println(level + "Handler进行处理");
            String message = this.doHandler(level);
            System.out.println(message);
        } else {
            System.out.println("本类无法处理，转接给其他handler处理");
            this.nextHandler.handler(level);
        }

    }

    public static void main(String[] args) {
        FirstLoyHandler firstLoyHandler =  new FirstLoyHandler();
        SecondLoyHandler secondLoyHandler =  new SecondLoyHandler();
        ThreeLoyHandler threeLoyHandler = new ThreeLoyHandler();
        firstLoyHandler.setNextHandler(secondLoyHandler);
        secondLoyHandler.setNextHandler(threeLoyHandler);

        System.out.println("=============交给其他handler处理测试===========");
        firstLoyHandler.handler(3);


        System.out.println("==============本类进行handler处理测试==========");
        firstLoyHandler.handler(1);

    }
}
