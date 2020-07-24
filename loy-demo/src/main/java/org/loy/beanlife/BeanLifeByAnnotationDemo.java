/*
 * 深圳市Loy有限公司版权所有.
 */
package org.loy.beanlife;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * 通过注解方式初始化bean
 *
 * @author Loy
 * @version 1.0.0
 * @date 2020/7/23
 */
@Component
public class BeanLifeByAnnotationDemo {
    private String beanName;

    @PostConstruct
    public void init() {
        beanName = "loy";
        System.out.println(beanName);
    }

    @PreDestroy
    public void destory() {
        System.out.println("bean销毁");
    }
}
