package org.example;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = "org.example")
@SpringBootApplication(exclude =  {DataSourceAutoConfiguration.class })
@Slf4j
public class Main {
    public static void main(String[] args) {
        log.info("Application is going to Start");
        SpringApplication.run(Main.class, args);
        log.info("Application running Started");
    }


}