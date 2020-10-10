/*
 * 深圳市Loy有限公司版权所有.
 */
package org.loy.spring.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * Bean的完整生命周期
 *
 * @author Loy
 * @version 1.0.0
 * @date 2020/10/9
 */
@Component
public class BeanLifeDemo implements BeanNameAware, BeanFactoryAware, InitializingBean, ApplicationContextAware, BeanPostProcessor,DisposableBean {

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("优先级2================>beanFactory=====");
    }

    @Override
    public void setBeanName(String s) {
        System.out.println("优先级1================>setBeanName=====" + s);
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("================>destroy=====");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("优先级4================>afterPropertiesSet=====");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("优先级3================>setApplicationContext=====");
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (beanName.equals("loyCommBean")) {
            System.out.println("优先级5================>postProcessBeforeInitialization=====");
        }
        return null;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (beanName.equals("loyCommBean")) {
            System.out.println("优先级6================>postProcessAfterInitialization=====");
        }
        return null;
    }
}
