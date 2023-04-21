package top.kangyong.sbsj;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Start
 *
 * @author Kang Yong
 * @date 2023/4/21
 * @since 1.0.0
 */
@MapperScan(value = "top.kangyong.sbsj.mapper")
@SpringBootApplication
public class SbsjApplication {

    public static void main(String[] args) {
        SpringApplication.run(SbsjApplication.class, args);
    }

}
