package top.kangyong.study.aevent.service;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import top.kangyong.study.aevent.domain.model.User;

import static org.junit.jupiter.api.Assertions.*;

/**
 * test
 *
 * @author Kang Yong
 * @date 2022/12/29
 * @since 1.0.0
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void updateById() {
    }

    @Test
    public void insert() {
        User user = new User();
        user.setId(1);
        user.setName("张三");
        user.setIdNo("340321199510241111");
        user.setPhone("18225608251");

        userService.insert(user);

        while (true) {

        }

    }
}