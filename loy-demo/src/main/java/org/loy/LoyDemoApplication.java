/*
 * 深圳市Loy有限公司版权所有.
 */
package org.loy;

import org.loy.spring.bean.LoyBeanLoadDemo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.support.BeanDefinitionReader;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.core.io.ClassPathResource;

/**
 * loy-demo入口类
 *
 * @author Loy
 * @version 1.0.0
 * @date 2020/7/22
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
//@SpringBootApplication()
@MapperScan(basePackages = {"org.loy.mapper"})
public class LoyDemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(LoyDemoApplication.class, args);
    }
}
