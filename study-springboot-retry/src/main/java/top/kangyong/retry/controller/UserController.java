package top.kangyong.retry.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import top.kangyong.retry.service.UserService;

/**
 * 用户 控制层
 *
 * @author Kang Yong
 * @date 2023/5/20
 * @since 1.0.0
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 获取用户数量
     *
     * @param code {@link Integer}
     * @return {@link Integer}
     * @author Kang Yong
     * @date 2023/5/20
     */
    @GetMapping("/user/count/{code}")
    public Integer getUserCount(@PathVariable(value = "code") Integer code) {
        // 这里捕获或者抛出都不影响重试
        try {
            return userService.getUserCount(code);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return 1;
    }

}
