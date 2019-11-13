package org.loy;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableEurekaClient
@EnableFeignClients
@ComponentScan(basePackages = {"org.loy.*"})
@Slf4j
public class LoyConsumerApplication {

    public static void main(String[] args) {
        log.info("=========loy consumer run start===============");
        SpringApplication.run(LoyConsumerApplication.class, args);
        log.info("=========loy consumer run success===============");
    }

}
