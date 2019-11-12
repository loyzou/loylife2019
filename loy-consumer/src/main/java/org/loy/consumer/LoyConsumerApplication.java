package org.loy.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@Slf4j
public class LoyConsumerApplication {

    public static void main(String[] args) {
        log.info("=========loy consumer run start===============");
        SpringApplication.run(LoyConsumerApplication.class, args);
        log.info("=========loy consumer run success===============");
    }

}
