package top.kangyong.springboot.property.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.io.Serializable;
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

    private List<MsgTemplate> msgTemplateList;

    @Data
    @ToString
    public static class MsgTemplate implements Serializable {
        private String wxAppId;
        private String opening;
        private String priceChanges;
        private String subscribe;
    }
}
