package top.kangyong.study.redis.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * test
 *
 * @author Kang Yong
 * @date 2023/3/15
 * @since 1.0.0
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class RedisListenerTest {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Test
    public void convertAndSendTest() {
        redisTemplate.convertAndSend("myTopic", "Hello, world!");
        System.out.println("convert end");
    }
}
