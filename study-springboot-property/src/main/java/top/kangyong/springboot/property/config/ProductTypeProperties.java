package top.kangyong.springboot.property.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;

/**
 * properties
 *
 * @author Kang Yong
 * @date 2023/10/31
 * @since 1.0.0
 */
@Data
@Component
@ConfigurationProperties(prefix = "study-property")
public class ProductTypeProperties implements Serializable {

    /**
     * 读取配置文件的list
     */
    private List<String> productTypeList;
}
