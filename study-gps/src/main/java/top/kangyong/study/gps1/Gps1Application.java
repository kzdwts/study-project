package top.kangyong.study.gps1;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * 启动
 *
 * @author Kang Yong
 * @date 2024/4/30
 * @since 1.0.0
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class Gps1Application {
    public static void main(String[] args) {
        System.out.println("Hello world!");

    }
}