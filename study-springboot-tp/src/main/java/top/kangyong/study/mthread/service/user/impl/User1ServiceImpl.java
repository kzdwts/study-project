package top.kangyong.study.mthread.service.user.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import top.kangyong.study.mthread.domain.User1;
import top.kangyong.study.mthread.service.user.User1Service;
import top.kangyong.study.mthread.mapper.User1Mapper;
import org.springframework.stereotype.Service;

/**
 * @author KY
 * @description 针对表【user1】的数据库操作Service实现
 * @createDate 2023-02-13 21:02:54
 */
@Service
public class User1ServiceImpl extends ServiceImpl<User1Mapper, User1> implements User1Service {

    @Autowired
    private User1Mapper user1Mapper;

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void addRequired(User1 user1) {
        user1Mapper.insert(user1);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Override
    public void addRequiresNew(User1 user1) {
        user1Mapper.insert(user1);
    }

    @Transactional(propagation = Propagation.NESTED)
    @Override
    public void addNested(User1 user1) {
        user1Mapper.insert(user1);
    }

}




