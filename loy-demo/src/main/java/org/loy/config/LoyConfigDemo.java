/*
 * 深圳市Loy有限公司版权所有.
 */
package org.loy.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * 待测试注入的对象
 *
 * @author Loy
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
