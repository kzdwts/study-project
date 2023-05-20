package top.kangyong.retry.service.impl;

import org.springframework.stereotype.Service;
import top.kangyong.retry.service.UserService;

import java.time.LocalTime;

/**
 * 用户业务实现层
 *
 * @author Kang Yong
 * @date 2023/5/20
 * @since 1.0.0
 */
@Service
public class UserServiceImpl implements UserService {


    @Override
    public Integer getUserCount(Integer code) throws Exception {
        System.out.println("UserServiceImpl[getUserCount] 被调用：" + LocalTime.now());

        if (code == 0) {
            throw new Exception("情况不对头！");
        }

        System.out.println("UserServiceImpl[getUserCount] 被正常调用，情况对头了！" + LocalTime.now());

        return 101;
    }

}
