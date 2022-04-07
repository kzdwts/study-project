package top.kangyong.asyncdemo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.kangyong.asyncdemo.core.util.RespResult;
import top.kangyong.asyncdemo.service.UserService;

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
}
