package top.kangyong.sentinalnew.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * start
 *
 * @author Kang Yong
 * @date 2023/1/29
 * @since 1.0.0
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class SGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(SGatewayApplication.class, args);
    }

}
