/*
 * 深圳市灵智数科有限公司版权所有.
 */
package org.loy.handlerchain_demo;

import java.util.logging.Level;

/**
 * 功能说明
 *
 * @author 邹全洪
 * @version 1.0.0
 * @date 2020/7/28
 */
public class FirstLoyHandler extends LoyHandler {
    private final int LEVEL = 1;
    @Override
    public int getLevel() {
        System.out.println("进入" + LEVEL + "获取当前LEVEL");
        return LEVEL;
    }

    @Override
    public String doHandler(int level) {
        return "第" + LEVEL + "个handler处理完成";
    }
}
