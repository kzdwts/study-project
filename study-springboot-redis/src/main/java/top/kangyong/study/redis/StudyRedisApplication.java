package top.kangyong.study.redis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;

/**
 * 启动类
 *
 * @author Kang Yong
 * @date 2022/3/11
 * @since 1.0.0
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class StudyRedisApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudyRedisApplication.class, args);
    }
}
