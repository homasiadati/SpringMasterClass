package com.mahd312.springmasterclass;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
@EnableFeignClients
public class SpringMasterClassApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringMasterClassApplication.class, args);
    }

}
