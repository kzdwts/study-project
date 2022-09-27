package top.kangyong.springboot.property.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * 配置
 *
 * @author Kang Yong
 * @date 2022/9/27
 * @since 1.0.0
 */
@Data
@Component
@ConfigurationProperties(prefix = "study-property")
public class MsgTemplateProperties {

    private List<Map<String, String>> msgTemplateList;

}
