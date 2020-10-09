/*
 * 深圳市Loy有限公司版权所有.
 */
package org.loy.beanfactory;

import java.util.Date;

/**
 * 功能说明
 *
 * @author 邹全洪
 * @version 1.0.0
 * @date 2020/8/31
 */
public class LoyBeanFactory  {
    public static void main(String[] args) {
        Date date = new Date();
        System.out.println(date.getTime() - 360*10);
        System.out.println(date.getTime() - (360*10));

    }
}
