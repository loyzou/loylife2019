package org.loy.loylife;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"org.loy.*"})
@Slf4j
public class LoyLifeApplication {

    public static void main(String[] args) {
        log.info("========loy application run start!!!========");
        SpringApplication.run(LoyLifeApplication.class, args);
        log.info("========loy application run success!!!========");
    }

}
