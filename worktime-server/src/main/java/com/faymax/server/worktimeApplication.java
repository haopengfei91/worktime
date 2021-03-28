package com.faymax.server;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.swing.*;

@SpringBootApplication
@MapperScan("com.faymax.server.mapper")
public class worktimeApplication {

    public static void main(String[] args) {
        SpringApplication.run(worktimeApplication.class, args);
    }
}

