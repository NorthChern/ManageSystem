package com.north.managesystem;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.north.managesystem.mapper")
public class ManageSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(ManageSystemApplication.class, args);
    }

}
