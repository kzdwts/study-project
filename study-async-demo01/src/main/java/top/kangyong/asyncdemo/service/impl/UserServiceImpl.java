package top.kangyong.asyncdemo.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import top.kangyong.asyncdemo.service.UserService;

/**
 * 用户
 *
 * @author Kang Yong
 * @date 2022/4/7
 * @since 1.0.0
 */
@Slf4j
@Service
public class UserServiceImpl implements UserService {
    /**
     * sync 更新用户
     *
     * @author Kang Yong
     * @date 2022/4/7
     */
    @Override
    public void syncUser() {
        log.info("===sync 更新用户===START===");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("===sync 更新用户===END===");
    }

    /**
     * async 更新用户
     *
     * @author Kang Yong
     * @date 2022/4/7
     */
    @Async
    @Override
    public void asyncUser() {
        log.info("===async 更新用户===START===");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("===async 更新用户===END===");
    }
}
