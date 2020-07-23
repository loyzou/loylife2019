/*
 * 深圳市灵智数科有限公司版权所有.
 */
package org.loy.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * 功能说明
 *
 * @author 邹全洪
 * @version 1.0.0
 * @date 2020/7/22
 */
@Component
public class LoyConfig {
    @ConfigurationProperties(prefix = "loy.config")
    public LoyConfigDemo2 loyConfigDemo2() {
        return new LoyConfigDemo2();
    }
}
