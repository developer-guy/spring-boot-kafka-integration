package com.bthnapaydin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

/**
 * Created by bapaydin on 27.02.2017.
 */

@SpringBootApplication
@ComponentScan(basePackages = "com.bthnapaydin")
@PropertySource(value = "classpath:application.properties")
public class SpringBootKafkaApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootKafkaApplication.class,args);
    }
}
