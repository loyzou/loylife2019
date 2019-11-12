package org.loy;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
@Slf4j
public class LoyEurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(LoyEurekaApplication.class, args);
        log.info("======eureka server run success=========");
    }

}
