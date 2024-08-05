package top.kangyong.study.redissson;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * start
 *
 * @author Kang Yong
 * @date 2024/8/2
 * @since 1.0.0
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class SSRApplication {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        SpringApplication.run(SSRApplication.class, args);
    }
}