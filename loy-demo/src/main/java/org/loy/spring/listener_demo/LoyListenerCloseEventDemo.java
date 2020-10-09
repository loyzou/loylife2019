/*
 * 深圳市Loy有限公司版权所有.
 */
package org.loy.spring.listener_demo;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.stereotype.Component;

/**
 * 容器关闭监听事件
 * 备注： 独立容器关闭监听事件
 *
 * @author Loy
 * @version 1.0.0
 * @date 2020/10/9
 */
@Component
public class LoyListenerCloseEventDemo implements ApplicationListener<ContextClosedEvent> {
    @Override
    public void onApplicationEvent(ContextClosedEvent contextClosedEvent) {
        System.out.println("容器关闭时，进入监听事件======》" +  contextClosedEvent.toString());

    }
}
