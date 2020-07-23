/*
 * 深圳市灵智数科有限公司版权所有.
 */
package org.loy.common;

import org.springframework.stereotype.Component;

/**
 * 公用测试bean
 *
 * @author 邹全洪
 * @version 1.0.0
 * @date 2020/7/22
 */
@Component
public class LoyCommBean {
    static {
        System.out.println("公用bean初始化");
    }
}
