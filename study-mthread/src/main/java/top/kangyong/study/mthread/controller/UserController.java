package top.kangyong.study.mthread.controller;

import com.baomidou.mybatisplus.extension.api.R;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.kangyong.study.mthread.domain.User;
import top.kangyong.study.mthread.service.UserService;

import javax.annotation.Resource;

/**
 * controller
 *
 * @author Kang Yong
 * @date 2023/3/30
 * @since 1.0.0
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    /**
     * 新增用户
     *
     * @param user {@link User}
     * @return {@link R}
     * @author Kang Yong
     * @date 2023/4/3
     */
    @PostMapping("/addUser")
    public R addUser(@RequestBody User user) {
        userService.addUser(user);
        return R.ok("SUCCESS");
    }

    /**
     * 查询生日，并发送短信
     *
     * @return {@link R}
     * @author Kang Yong
     * @date 2023/3/30
     */
    @PostMapping("/congratulation")
    public R checkBirthdayAndSendCongratulation() {
        userService.checkBirthdayAndSendCongratulation();
        return R.ok("SUCCESS");
    }
}
