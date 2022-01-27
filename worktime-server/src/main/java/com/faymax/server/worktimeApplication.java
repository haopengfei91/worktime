package com.faymax.server;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import javax.swing.*;

@SpringBootApplication
@MapperScan("com.faymax.server.mapper")
@EnableScheduling
public class worktimeApplication {

    public static void main(String[] args) {
        SpringApplication.run(worktimeApplication.class, args);
    }
}

