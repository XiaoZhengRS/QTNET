package com.xiaozhengkeji.qtnet;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@SpringBootApplication
@EnableDiscoveryClient
@MapperScan(basePackages = {"com.xiaozhengkeji.qtnet.dao"})
public class UserProvider {
    public static void main(String[] args) {
        SpringApplication.run(UserProvider.class, args);
    }


}
