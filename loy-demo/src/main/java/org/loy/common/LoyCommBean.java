/*
 * 深圳市Loy有限公司版权所有.
 */
package org.loy.common;

import org.springframework.stereotype.Component;

/**
 * 公用测试bean
 *
 * @author Loy
 * @version 1.0.0
 * @date 2020/7/22
 */
@Component
public class LoyCommBean {
    public LoyCommBean() {
        System.out.println("LoyCommBean construct");
    }
    static {
        System.out.println("公用bean初始化");
    }
}
