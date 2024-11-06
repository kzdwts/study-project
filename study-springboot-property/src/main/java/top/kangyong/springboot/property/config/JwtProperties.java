package top.kangyong.springboot.property.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * 读取配置测试
 *
 * @author Kang Yong
 * @date 2024/11/6
 * @since 1.0.0
 */
@Data
@Component
@ConfigurationProperties(prefix = "study-property")
public class JwtProperties implements Serializable {

    @Value("${study-property.jwt.host:60.175.255.98:446}")
    private String host;

    @Value("${study-property.jwt.ak:123}")
    private String ak;

    @Value("${study-property.jwt.sk:sk123}")
    private String sk;
}
