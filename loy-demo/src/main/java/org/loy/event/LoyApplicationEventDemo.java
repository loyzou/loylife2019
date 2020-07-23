/*
 * 深圳市灵智数科有限公司版权所有.
 */
package org.loy.event;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * 监听事件demo
 *
 * @author 邹全洪
 * @version 1.0.0
 * @date 2020/7/22
 */
@Component
public class LoyApplicationEventDemo implements ApplicationListener<ApplicationEvent> {

    @Override
    public void onApplicationEvent(ApplicationEvent applicationEvent) {
        System.out.println("监听事件demo进入");
    }
}
