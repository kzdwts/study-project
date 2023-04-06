package top.kangyong.study.mthread;

import org.mybatis.spring.annotation.MapperScan;
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
@MapperScan("top.kangyong.study.mthread.mapper")
@SpringBootApplication
public class MthreadApplication {

    public static void main(String[] args) {
        SpringApplication.run(MthreadApplication.class, args);
    }

}
