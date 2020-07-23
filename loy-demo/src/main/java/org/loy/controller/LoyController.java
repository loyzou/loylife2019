/*
 * 深圳市灵智数科有限公司版权所有.
 */
package org.loy.controller;

import org.loy.config.LoyConfigDemo;
import org.loy.config.LoyConfigDemo2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 功能说明
 *
 * @author 邹全洪
 * @version 1.0.0
 * @date 2020/7/22
 */

@RestController
public class LoyController {
    @Autowired
    private LoyConfigDemo loyConfigDemo;
    @Autowired
    private LoyConfigDemo2 loyConfigDemo2;
    @RequestMapping("test1")
    public String test1() {
        System.out.println(loyConfigDemo.getName() + loyConfigDemo.getLife());
        System.out.println(loyConfigDemo2.getName());

        return "test1";
    }
}
