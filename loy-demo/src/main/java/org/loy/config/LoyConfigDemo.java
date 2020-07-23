/*
 * 深圳市灵智数科有限公司版权所有.
 */
package org.loy.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * 功能说明
 *
 * @author 邹全洪
 * @version 1.0.0
 * @date 2020/7/22
 */
@Configuration
@ConfigurationProperties(prefix = "loy")
@Data
public class LoyConfigDemo {
    private String name;
    private String life;
}
