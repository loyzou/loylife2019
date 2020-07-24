/*
 * 深圳市Loy有限公司版权所有.
 */
package org.loy.beanlife;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

/**
 * 功能说明
 *
 * @author Loy
 * @version 1.0.0
 * @date 2020/7/23
 */
@Component
public class BeanLifeByImplInitBeanDemo implements InitializingBean , DisposableBean {
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("BeanLifeByImplInitBean bean 进入初始化");
    }

    @Override
    public void destroy() throws Exception {
        // 停止服务时，会进行销毁
        System.out.println("BeanLifeByImplInitBean bean 销毁");
    }
}
