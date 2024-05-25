package com.kangyong.mpdm;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * start
 *
 * @author Kang Yong
 * @date 2024/5/26
 * @since 1.0.0
 */
@MapperScan("com.kangyong.mpdm.mapper")
@SpringBootApplication
public class MpDmApplication {

    public static void main(String[] args) {
        SpringApplication.run(MpDmApplication.class, args);
    }
}
