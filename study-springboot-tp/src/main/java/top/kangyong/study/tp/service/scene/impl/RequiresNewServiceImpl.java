package top.kangyong.study.tp.service.scene.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import top.kangyong.study.tp.domain.User1;
import top.kangyong.study.tp.domain.User2;
import top.kangyong.study.tp.service.scene.RequiresNewService;
import top.kangyong.study.tp.service.user.User1Service;
import top.kangyong.study.tp.service.user.User2Service;

/**
 * @author Kang Yong
 * @date 2023/2/15
 * @since 1.0.0
 */
@Service
public class RequiresNewServiceImpl implements RequiresNewService {

    @Autowired
    private User1Service user1Service;

    @Autowired
    private User2Service user2Service;

//  场景一：外围方法没有开启事务

    /**
     * 验证方法一
     *
     * @author Kang Yong
     * @date 2023/2/15
     */
    @Override
    public void notransaction_exception_requiresNew_requiresNew() {
        User1 user1 = new User1();
        user1.setName("张三");
        user1Service.addRequiresNew(user1);

        User2 user2 = new User2();
        user2.setName("李四");
        user2Service.addRequiresNew(user2);

        throw new RuntimeException();
    }

    /**
     * 验证方法二
     *
     * @author Kang Yong
     * @date 2023/2/15
     */
    @Override
    public void notransaction_requiresNew_requiresNew_exception() {
        User1 user1 = new User1();
        user1.setName("张三");
        user1Service.addRequiresNew(user1);

        User2 user2 = new User2();
        user2.setName("李四");
        user2Service.addRequiresNewException(user2);
    }


//    场景二：外围方法开启事务

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void transaction_exception_required_requiresNew_requiresNew() {
        User1 user1 = new User1();
        user1.setName("张三");
        user1Service.addRequired(user1);

        User2 user2 = new User2();
        user2.setName("李四");
        user2Service.addRequiresNew(user2);

        User2 user3 = new User2();
        user3.setName("王五");
        user2Service.addRequiresNew(user3);

        throw new RuntimeException();
    }

    @Override
    public void transaction_required_requiresNew_requiresNew_exception() {
        User1 user1 = new User1();
        user1.setName("张三");
        user1Service.addRequired(user1);

        User2 user2 = new User2();
        user2.setName("李四");
        user2Service.addRequiresNew(user2);

        User2 user3 = new User2();
        user3.setName("王五");
        user2Service.addRequiresNewException(user3);

    }

    @Override
    public void transaction_required_requiresNew_requiresNew_exception_try() {
        User1 user1 = new User1();
        user1.setName("张三");
        user1Service.addRequired(user1);

        User2 user2 = new User2();
        user2.setName("李四");
        user2Service.addRequiresNew(user2);

        User2 user3 = new User2();
        user3.setName("王五");
        try {
            user2Service.addRequiresNewException(user3);
        } catch (Exception e) {
            System.out.println("回滚");
        }

    }


}
