package com.kangyong.springboot.mpt;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 启动
 *
 * @author Kang Yong
 * @date 2024/6/13
 * @since 1.0.0
 */
@MapperScan(basePackages = {"com.kangyong.springboot.mpt.mapper"})
@SpringBootApplication
public class MptApplication {

    public static void main(String[] args) {
        SpringApplication.run(MptApplication.class, args);
    }

}
