package top.kangyong.study.mthread.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import top.kangyong.study.mthread.domain.User;
import top.kangyong.study.mthread.service.UserService;
import top.kangyong.study.mthread.mapper.UserMapper;
import org.springframework.stereotype.Service;

/**
* @author KY
* @description 针对表【user】的数据库操作Service实现
* @createDate 2023-03-31 17:53:09
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{

}




