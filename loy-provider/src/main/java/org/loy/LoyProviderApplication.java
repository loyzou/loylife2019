package org.loy;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@Slf4j
public class LoyProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(LoyProviderApplication.class, args);
    }

}
