package com.kangyong.study.minio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * 启动
 *
 * @author Kang Yong
 * @date 2024/5/21
 * @since 1.0.0
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class MinioServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(MinioServerApplication.class, args);
    }

}
