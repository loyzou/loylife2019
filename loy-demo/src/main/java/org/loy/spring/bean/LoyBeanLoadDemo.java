/*
 * 深圳市Loy有限公司版权所有.
 */
package org.loy.spring.bean;

import org.springframework.beans.factory.support.BeanDefinitionReader;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;

/**
 * 通过资源加载的方式加载Bean
 *
 * @author Loy
 * @version 1.0.0
 * @date 2020/10/10
 */
public class LoyBeanLoadDemo {
    private String beanName;

    public String getBeanName() {
        return beanName;
    }

    public void setBeanName(String beanName) {
        this.beanName = beanName;
    }

    public static void main(String[] args) {
        // 装载bean
        ClassPathResource classPathResource = new ClassPathResource("bean.xml");
        DefaultListableBeanFactory listableBeanFactory = new DefaultListableBeanFactory();
        BeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(listableBeanFactory);
        beanDefinitionReader.loadBeanDefinitions(classPathResource);

        LoyBeanLoadDemo loyBeanLoadDemo2 = listableBeanFactory.getBean(LoyBeanLoadDemo.class);

        System.out.println("装载结束" + loyBeanLoadDemo2.getBeanName());
    }
}
