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
 * <p>
 * 如果当前存在事务，则在嵌套事务内执行。
 * 如果当前没有事务，则执行与Propagation.REQUIRED类似的操作
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
//    通过这两个方法我们证明了在外围方法未开启事务的情况下Propagation.NESTED和Propagation.REQUIRED作用相同，
//    修饰的内部方法都会新开启自己的事务，且开启的事务相互独立，互不干扰

    /**
     * 验证方法一
     * <p>
     * 数据库结果：“张三”，“李四”均插入
     * <p>
     * 结果分析：外围方法未开启事务，插入“张三”、“李四”方法在自己的事务中独立运行，
     * 外围方法异常不影响内部插入“张三“、”李四“方法的独立的事务
     *
     * @author Kang Yong
     * @date 2023/2/20
     */
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

    /**
     * 验证方法二
     * <p>
     * 数据库结果：“张三”插入，“李四”未插入
     * <p>
     * 结果分析：外围方法未开启事务，插入“张三”、“李四”方法在自己的事务中独立运行，
     * 所以插入”李四“方法抛出异常只会回滚插入”李四“方法插入“张三“方法不受影响
     */
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

    /**
     * 验证方法一
     * <p>
     * 数据库结果：“张三”,“李四”未均插入
     * <p>
     * 结果分析：外围方法开启事务，内部事务为外围事务的子事务，外围方法回滚，内部方法也要回滚
     */
    @Transactional // 默认spring事务传播行为 propagation = Propagation.REQUIRED
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

    /**
     * 验证方法二
     * <p>
     * 数据库结果：“张三”,“李四”未均插入
     * <p>
     * 结果分析：外围方法开启事务，内部事务为外围事务的子事务，内部方法抛出异常回滚，
     * 且外围方法感知异常致使整体事务回滚
     */
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

    /**
     * 验证方法三
     * <p>
     * 数据库结果：“张三”插入,“李四”未插入
     * <p>
     * 结果分析：外围方法开启事务，内部事务为外围事务的子事务，
     * 插入“李四”内部方法抛出异常，可以单独对子事务回滚
     */
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
