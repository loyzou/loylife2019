/*
 * 深圳市Loy有限公司版权所有.
 */
package org.loy.controller;

import org.loy.entity.LoyEntity;
import org.loy.service.LoyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 主控制类
 *
 * @author loy
 * @version 1.0.0
 * @date 2020/7/22
 */

@RestController
public class LoyController {
    @Autowired
    private LoyService loyService;

    @RequestMapping("test1")
    public String test1() {
        List<LoyEntity> list = loyService.listLoy();
        return String.valueOf(list.size());
    }
}
