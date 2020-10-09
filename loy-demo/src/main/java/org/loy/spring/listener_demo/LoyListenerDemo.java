/*
 * 深圳市Loy有限公司版权所有.
 */
package org.loy.spring.listener_demo;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * 说明： 通过实现ApplicationListener及ApplicationEvent实现事件的监听
 *       该监听事件会监听ContextRefreshedEvent 容器刷新事件
 *                     ServletWebServerInitializedEvent  web服务初始化成功事件
 *                     ApplicationStartedEvent 容器启动事件
 *                     ApplicationReadyEvent 容器准备事件
 *                     ContextClosedEvent    容器关闭事件
 * 备注： 此事件几乎包含所有的SpringEvent
 *
 * @author Loy
 * @version 1.0.0
 * @date 2020/10/9
 */
@Component
public class LoyListenerDemo implements ApplicationListener<ApplicationEvent> {
    @Override
    public void onApplicationEvent(ApplicationEvent applicationEvent) {
        // 当容器初始化完成时，将会调用该方法
        System.out.println("====容器初始化完成==========》" + applicationEvent.toString());
    }
}
