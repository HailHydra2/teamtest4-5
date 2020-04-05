package com.fzu.teamtest;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = {"com.fzu.teamtest.dao"})
public class TeamtestApplication {

    public static void main(String[] args) {
        SpringApplication.run(TeamtestApplication.class, args);
    }

}
