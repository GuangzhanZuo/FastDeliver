package com.qingyang.fastdeliver;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.qingyang.fastdeliver.dao")
public class FastDeliverApplication {

    public static void main(String[] args) {
        SpringApplication.run(FastDeliverApplication.class, args);
    }

}
