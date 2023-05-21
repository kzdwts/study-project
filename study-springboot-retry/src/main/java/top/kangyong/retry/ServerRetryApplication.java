package top.kangyong.retry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.retry.annotation.Retryable;

/**
 * start
 *
 * @author Kang Yong
 * @date 2023/5/18
 * @since 1.0.0
 */
@EnableRetry
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class ServerRetryApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServerRetryApplication.class, args);
    }

}
