package top.kangyong.springboot.property.config;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 读取Value配置
 *
 * @author Kang Yong
 * @date 2024/11/6
 * @since 1.0.0
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class JwtPropertiesTest {

    @Autowired
    private JwtProperties jwtProperties;

    @Test
    public void print() {
        System.out.println("jwtProperties.getHost() = " + jwtProperties.getHost());
        System.out.println("jwtProperties.getAk() = " + jwtProperties.getAk());
        System.out.println("jwtProperties.getSk() = " + jwtProperties.getSk());
    }

}