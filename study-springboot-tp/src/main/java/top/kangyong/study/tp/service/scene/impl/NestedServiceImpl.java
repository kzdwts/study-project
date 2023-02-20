package top.kangyong.study.tp.service.scene.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.kangyong.study.tp.domain.User1;
import top.kangyong.study.tp.domain.User2;
import top.kangyong.study.tp.service.scene.NestedService;
import top.kangyong.study.tp.service.user.User1Service;
import top.kangyong.study.tp.service.user.User2Service;

/**
 * nested
 *
 * @author Kang Yong
 * @date 2023/2/16
 * @since 1.0.0
 */
@Service
public class NestedServiceImpl implements NestedService {

    @Autowired
    private User1Service user1Service;

    @Autowired
    private User2Service user2Service;

//    场景一：此场景外围方法没有开启事务

    @Override
    public void notransaction_exception_nested_nested() {
        User1 user1 = new User1();
        user1.setName("张三");
        user1Service.addNested(user1);

        User2 user2 = new User2();
        user2.setName("李四");
        user2Service.addNested(user2);

        throw new RuntimeException();
    }

    @Override
    public void notransaction_nested_nested_exception() {
        User1 user1 = new User1();
        user1.setName("张三");
        user1Service.addNested(user1);

        User2 user2 = new User2();
        user2.setName("李四");
        user2Service.addNestedException(user2);
    }

//    场景二：外围方法开启事务

    @Transactional // 默认spring事务传播行为 propagation = Propagation.NESTED
    @Override
    public void transaction_exception_nested_nested() {
        User1 user1 = new User1();
        user1.setName("张三");
        user1Service.addNested(user1);

        User2 user2 = new User2();
        user2.setName("李四");
        user2Service.addNested(user2);

        throw new RuntimeException();
    }

    @Transactional
    @Override
    public void transaction_nested_nested_exception() {
        User1 user1 = new User1();
        user1.setName("张三");
        user1Service.addNested(user1);

        User2 user2 = new User2();
        user2.setName("李四");
        user2Service.addNestedException(user2);
    }

    @Transactional
    @Override
    public void transaction_nested_nested_exception_try() {
        User1 user1 = new User1();
        user1.setName("张三");
        user1Service.addNested(user1);

        User2 user2 = new User2();
        user2.setName("李四");
        try {
            user2Service.addNestedException(user2);
        } catch (Exception e) {
            System.out.println("方法回滚");
        }
    }
}
