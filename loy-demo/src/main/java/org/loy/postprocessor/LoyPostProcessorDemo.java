/*
 * 深圳市Loy有限公司版权所有.
 */
package org.loy.postprocessor;

import org.loy.common.NoComponentLoyCommBean;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.stereotype.Component;

/**
 * 功能说明
 *
 * @author Loy
 * @version 1.0.0
 * @date 2020/7/23
 */
@Component
public class LoyPostProcessorDemo implements BeanDefinitionRegistryPostProcessor {
    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry beanDefinitionRegistry) throws BeansException {
        // 动态添加NoComponentLoyCommBean
        System.out.println("动态添加bean之前的bean个数：" + beanDefinitionRegistry.getBeanDefinitionCount());
        RootBeanDefinition rootBeanDefinition = new RootBeanDefinition(NoComponentLoyCommBean.class);
        beanDefinitionRegistry.registerBeanDefinition("loyNoComponentLoyCommBean", rootBeanDefinition);


    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        NoComponentLoyCommBean noComponentLoyCommBean = configurableListableBeanFactory.getBean(NoComponentLoyCommBean.class);
        System.out.println("测试添加的bean：" + noComponentLoyCommBean);
        System.out.println("动态添加bean之前的bean个数：" + configurableListableBeanFactory.getBeanDefinitionCount());
    }
}
