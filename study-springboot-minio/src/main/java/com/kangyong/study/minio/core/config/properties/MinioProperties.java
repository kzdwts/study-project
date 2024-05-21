package com.kangyong.study.minio.core.config.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * Minio 配置参数
 *
 * @author Kang Yong
 * @date 2024/5/21
 * @since 1.0.0
 */
@Data
@Component
@ConfigurationProperties(prefix = "minio")
public class MinioProperties implements Serializable {

    private String endpoint;
    private String accessKey;
    private String secretKey;
    private String bucketName;

}
