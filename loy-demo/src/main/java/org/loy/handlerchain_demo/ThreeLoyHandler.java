/*
 * 深圳市Loy有限公司版权所有.
 */
package org.loy.handlerchain_demo;

/**
 * 功能说明
 *
 * @author Loy
 * @version 1.0.0
 * @date 2020/7/28
 */
public class ThreeLoyHandler extends LoyHandler {
    private final int LEVEL = 3;
    @Override
    public int getLevel() {
        System.out.println("进入" + LEVEL + "获取当前LEVEL");
        return 3;
    }

    @Override
    public String doHandler(int level) {
        return "第" + LEVEL + "个handler处理完成";
    }
}
