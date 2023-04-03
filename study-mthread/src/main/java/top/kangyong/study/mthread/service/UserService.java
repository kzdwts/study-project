package top.kangyong.study.mthread.service;

import top.kangyong.study.mthread.domain.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author KY
* @description 针对表【user】的数据库操作Service
* @createDate 2023-03-31 17:53:34
*/
public interface UserService extends IService<User> {

    void checkBirthdayAndSendCongratulation();

    void addUser(User user);
}
