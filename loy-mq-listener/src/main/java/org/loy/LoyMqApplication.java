package org.loy;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableFeignClients
@EnableEurekaClient
@ComponentScan(basePackages = {"org.loy.*"})
@Slf4j
public class LoyMqApplication {
    public static void main(String[] args) {
        System.out.println("================LoyMqApplication start====================");
        SpringApplication.run(LoyMqApplication.class,args);
        System.out.println("================LoyMqApplication end====================");
    }
}
