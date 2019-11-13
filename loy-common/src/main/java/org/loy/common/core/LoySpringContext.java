package org.loy.common.core;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/***
 * 上下文获取对象
 */
@Component
@Slf4j
public class LoySpringContext implements ApplicationContextAware {
    private static ApplicationContext applicationContext;
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        LoySpringContext.applicationContext = applicationContext;
    }

    /***
     * 获取applicationContext对象
     *
     */

    public static ApplicationContext getApplicationContext(){
        return applicationContext;
    }

    public static Object getBean(String beanId){
        if(beanId == null){
            return null;
        }
        try{
            return applicationContext.getBean(beanId);
        }catch (Exception e){
            log.debug("not found Bean:" + beanId);
        }
        return null;
    }

    /***
     * 获取bean对象
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T getBean(Class<T> clazz){
        if(clazz == null){
            return null;
        }
        try {
            return applicationContext.<T>getBean(clazz);
        }catch (Exception e){

        }
        return null;
    }
}
