package com.phy.pxlibrary;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@MapperScan(basePackages = {"com/phy/pxlibrary/dao"})
@SpringBootApplication
public class PxlibraryApplication {

    public static void main(String[] args) {
        SpringApplication.run(PxlibraryApplication.class, args);
    }

}
