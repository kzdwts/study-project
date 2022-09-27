package top.kangyong.springboot.property;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @author Kang Yong
 * @date 2022/9/27
 * @since 1.0.0
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class PropertyApplication {

    public static void main(String[] args) {
        SpringApplication.run(PropertyApplication.class, args);
    }

}
