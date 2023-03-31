package top.kangyong.study.mthread.service.user.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import top.kangyong.study.mthread.domain.User2;
import top.kangyong.study.mthread.mapper.User2Mapper;
import top.kangyong.study.mthread.service.user.User2Service;

/**
 * @author KY
 * @description 针对表【user2】的数据库操作Service实现
 * @createDate 2023-02-13 21:02:54
 */
@Service
public class User2ServiceImpl extends ServiceImpl<User2Mapper, User2> implements User2Service {

    @Autowired
    private User2Mapper user2Mapper;

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void addRequired(User2 user2) {
        user2Mapper.insert(user2);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void addRequiredException(User2 user2) {
        user2Mapper.insert(user2);

        System.out.println("User2ServiceImpl#addRequiredException 这里抛出异常，测试事务");
        throw new RuntimeException();
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Override
    public void addRequiresNew(User2 user2) {
        user2Mapper.insert(user2);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Override
    public void addRequiresNewException(User2 user2) {
        user2Mapper.insert(user2);

        System.out.println("User2ServiceImpl#addRequiresNewException 这里抛出异常，测试事务");
        throw new RuntimeException();
    }

    @Transactional(propagation = Propagation.NESTED)
    @Override
    public void addNested(User2 user2) {
        user2Mapper.insert(user2);
    }

    @Transactional(propagation = Propagation.NESTED)
    @Override
    public void addNestedException(User2 user2) {
        user2Mapper.insert(user2);
        throw new RuntimeException();
    }

}




