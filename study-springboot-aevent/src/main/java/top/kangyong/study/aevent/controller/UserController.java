package top.kangyong.study.aevent.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.kangyong.study.aevent.domain.model.User;
import top.kangyong.study.aevent.service.UserService;

/**
 * 用户controller
 *
 * @author Kang Yong
 * @date 2022/12/29
 * @since 1.0.0
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 新增用户
     *
     * @param user {@link User}
     * @return {@link String}
     * @author Kang Yong
     * @date 2022/12/29
     */
    @PostMapping("/save")
    public String save(@RequestBody User user) {
        userService.insert(user);
        return "SUCCESS";
    }
}
