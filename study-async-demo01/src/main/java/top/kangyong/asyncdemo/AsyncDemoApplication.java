package top.kangyong.asyncdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * 启动
 *
 * @author Kang Yong
 * @date 2022/4/7
 * @since 1.0.0
 */
//@EnableAsync // 放在这里和放在配置类上面都行
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class}) // 不用数据库
public class AsyncDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(AsyncDemoApplication.class, args);
    }

}
