package top.kangyong.asyncdemo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.kangyong.asyncdemo.core.util.RespResult;
import top.kangyong.asyncdemo.service.UserService;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * 用户
 *
 * @author Kang Yong
 * @date 2022/4/7
 * @since 1.0.0
 */
@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * sync同步
     *
     * @return {@link RespResult}
     * @author Kang Yong
     * @date 2022/4/7
     */
    @PostMapping("/sync")
    public RespResult syncUser() {
        log.info("===sync===START===");
        this.userService.syncUser();
        log.info("===sync===END===");
        return RespResult.ok();
    }

    /**
     * async异步
     *
     * @return {@link RespResult}
     * @author Kang Yong
     * @date 2022/4/7
     */
    @PostMapping("/async")
    public RespResult asyncUser() {
        log.info("===Async===START===");
        this.userService.asyncUser();
        log.info("===Async===END===");
        return RespResult.ok();
    }

    /**
     * 异步1
     *
     * @return {@link RespResult< String>}
     * @author Kang Yong
     * @date 2022/4/7
     */
    @PostMapping("/autoAsyncUser1")
    public RespResult<String> autoAsyncUser1() {
        log.info("===异步===START===");

        try {
            Future<String> future = this.userService.autoAsyncUser1();
            System.out.println("开始获取异步执行结果");
            String str = future.get(10000, TimeUnit.SECONDS);
            System.out.println(str);
        } catch (Exception e) {
            e.printStackTrace();
        }
        log.info("===异步===END===");
        return RespResult.ok();
    }

    /**
     * 异步2
     *
     * @return {@link RespResult< String>}
     * @author Kang Yong
     * @date 2022/4/7
     */
    @PostMapping("/autoAsyncUser2")
    public RespResult<String> autoAsyncUser2() {
        log.info("===异步===START===");

        try {
            AsyncResult<String> result = this.userService.autoAsyncUser2();
            System.out.println("开始获取异步执行结果");
            String str = result.get(1, TimeUnit.SECONDS);
            System.out.println(str);
        } catch (Exception e) {
            e.printStackTrace();
        }
        log.info("===异步===END===");
        return RespResult.ok();
    }
}
