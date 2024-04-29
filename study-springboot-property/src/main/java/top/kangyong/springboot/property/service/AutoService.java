package top.kangyong.springboot.property.service;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import top.kangyong.springboot.property.config.ProvinceProperties;

/**
 * 测试通过构造方法注入
 *
 * @author Kang Yong
 * @date 2024/4/29
 * @since 1.0.0
 */
@Service
public class AutoService {

    @Value("${spring.application.name}")
    private String appName;

    private ProvinceProperties provinceProperties;

    /**
     * 具体来说，当Spring创建Bean的时候，会按照以下的顺序选择构造方法：
     * <p>
     * 带有@Autowired注解的有参构造方法。
     * 不带@Autowired注解的有参构造方法。
     * 无参构造方法。
     *
     * @param provinceProperties
     */
    @Autowired
    public AutoService(ProvinceProperties provinceProperties) {
        this.provinceProperties = provinceProperties;
    }

    public void doIt() {
        System.out.println("JSON.toJSONString(provinceProperties) = " + JSON.toJSONString(provinceProperties));
        System.out.println("appName = " + appName);
    }
}
