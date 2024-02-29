package top.kangyong.study.easyes;


import org.dromara.easyes.starter.register.EsMapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * 启动类
 * <p>
 * Copyright © 2021 xpc1024 All Rights Reserved
 **/
@SpringBootApplication
@EsMapperScan("top.kangyong.study.easyes.mapper")
@EnableAsync
public class EeUseApplication {

    public static void main(String[] args) {
        SpringApplication.run(EeUseApplication.class, args);
    }

}
