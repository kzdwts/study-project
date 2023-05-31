package top.kangyong.retry.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * TODO description.
 *
 * @author Kang Yong
 * @date 2023/5/31
 * @since 1.0.0
 */
@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void getUserCount() throws Exception {
        // 测试类调用，也会执行重试机制
        userService.getUserCount(0);
    }
}
