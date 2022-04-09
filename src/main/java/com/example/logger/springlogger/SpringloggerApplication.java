package com.example.logger.springlogger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy(proxyTargetClass  = true)
public class SpringloggerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringloggerApplication.class, args);
    }

}
