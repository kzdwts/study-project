package top.kangyong.springboot.dep;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * 启动类
 *
 * @author Kang Yong
 * @date 2022/10/9
 * @since 1.0.0
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class DepApplication {

    public static void main(String[] args) {
        SpringApplication.run(DepApplication.class, args);
    }

}

