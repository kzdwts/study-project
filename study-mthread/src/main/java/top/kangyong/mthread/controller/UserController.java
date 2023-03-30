package top.kangyong.mthread.controller;

import com.baomidou.mybatisplus.extension.api.R;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.kangyong.mthread.service.UserService;

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
