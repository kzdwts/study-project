package com.kangyong.study.minio.core.config;

import com.kangyong.study.minio.core.config.properties.MinioProperties;
import io.minio.MinioClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * 初始化minio bean
 *
 * @author Kang Yong
 * @date 2024/5/21
 * @since 1.0.0
 */
@Component
public class MinioConfig {

    @Autowired
    private MinioProperties minioProperties;

    @Bean
    public MinioClient minioClient() {
        return MinioClient.builder()
                .endpoint(minioProperties.getEndpoint())
                .credentials(minioProperties.getAccessKey(), minioProperties.getSecretKey())
                .build();
    }

}
