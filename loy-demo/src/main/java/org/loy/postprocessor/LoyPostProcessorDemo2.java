/*
 * 深圳市Loy有限公司版权所有.
 */
package org.loy.postprocessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * 功能说明
 *
 * @author Loy
 * @version 1.0.0
 * @date 2020/7/23
 */
@Component
public class LoyPostProcessorDemo2 implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
       // System.out.println("LoyPostProcessorDemo2 before in--->" + beanName);
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
       //  System.out.println("LoyPostProcessorDemo2 after in--->" + beanName);
        return bean;
    }
}
