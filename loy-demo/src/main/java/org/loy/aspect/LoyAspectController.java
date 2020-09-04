/*
 * 深圳市Loy有限公司版权所有.
 */
package org.loy.aspect;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Loy切面请求控制测试进入类
 *
 * @author Loy
 * @version 1.0.0
 * @date 2020/9/4
 */
@RestController
@RequestMapping("/")
public class LoyAspectController {
    @RequestMapping("test")
    public void test(String loy) {
        System.out.println("loy====>" + loy);
    }
}
