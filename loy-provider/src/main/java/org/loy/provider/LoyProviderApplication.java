package org.loy.provider;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@Slf4j
public class LoyProviderApplication {

    public static void main(String[] args) {
        log.info("======loy provider run start==========");
        SpringApplication.run(LoyProviderApplication.class, args);
        log.info("======loy provider run success==========");
    }

}
