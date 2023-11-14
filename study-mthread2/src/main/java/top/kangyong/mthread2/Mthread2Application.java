package top.kangyong.mthread2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * 线程池案例
 *
 * @author Kang Yong
 * @date 2023/4/3
 * @since 1.0.0
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class Mthread2Application {

    public static void main(String[] args) {
        SpringApplication.run(Mthread2Application.class, args);
    }

}
