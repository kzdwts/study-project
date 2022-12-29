package top.kangyong.study.aevent;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * start
 *
 * @author Kang Yong
 * @date 2022/12/29
 * @since 1.0.0
 */
@ComponentScan(basePackages = {"top.kangyong.study.aevent.*"})
@MapperScan(basePackages = {"top.kangyong.study.aevent.mapper"})
@SpringBootApplication
public class AeventApplication {

    public static void main(String[] args) {
        SpringApplication.run(AeventApplication.class, args);
    }

}
