package top.kangyong.study.aevent.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.kangyong.study.aevent.domain.dto.SaveUserEventDTO;
import top.kangyong.study.aevent.domain.model.User;
import top.kangyong.study.aevent.mapper.UserMapper;
import top.kangyong.study.aevent.service.UserService;

/**
 * 用户业务
 *
 * @author Kang Yong
 * @date 2022/12/29
 * @since 1.0.0
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private ApplicationContext applicationContext;

    @Override
    public void updateById(User user) {
        System.out.println("开始更新用户:" + user.toString());

        System.out.println("===发送事件===START===");
        this.applicationContext.publishEvent(new SaveUserEventDTO(user, user.getId(), user.getIdNo()));
        System.out.println("===发送事件===END===");
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void insert(User user) {
        System.out.println("开始新增用户:" + user.toString());
        this.userMapper.insert(user);

        System.out.println("===发送事件===START===");
        this.applicationContext.publishEvent(new SaveUserEventDTO(user, user.getId(), user.getIdNo()));
        System.out.println("===发送事件===END===");
    }

}
