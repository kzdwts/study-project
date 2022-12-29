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
@SpringBootApplication
@MapperScan("top.kangyong.study.aevent.mapper")
public class AeventApplication {

    public static void main(String[] args) {
        SpringApplication.run(AeventApplication.class, args);
    }

}
