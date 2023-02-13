package top.kangyong.study.tp;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * start
 *
 * @author Kang Yong
 * @date 2023/2/13
 * @since 1.0.0
 */
@MapperScan(basePackages = "top.kangyong.study.tp.mapper")
@SpringBootApplication
public class TpApplication {

    public static void main(String[] args) {
        SpringApplication.run(TpApplication.class, args);
    }

}
