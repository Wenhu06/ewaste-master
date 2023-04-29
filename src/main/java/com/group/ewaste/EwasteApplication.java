package com.group.ewaste;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@MapperScan("com.group.ewaste.mapper")
@Configuration
public class EwasteApplication {

    public static void main(String[] args) {
        SpringApplication.run(EwasteApplication.class, args);
    }

}
