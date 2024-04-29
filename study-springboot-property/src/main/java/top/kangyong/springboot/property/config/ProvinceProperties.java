package top.kangyong.springboot.property.config;

import lombok.Data;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * 省份code: 省份名称
 * 读取配置文件map格式的数据
 *
 * @author Kang Yong
 * @date 2023/5/19
 * @since 1.0.0
 */
@Data
@ToString
@Component
@Configuration
@ConfigurationProperties(prefix = "study-property")
public class ProvinceProperties implements Serializable {

    private Map<Integer, String> provinceMap = new HashMap<>();
}
