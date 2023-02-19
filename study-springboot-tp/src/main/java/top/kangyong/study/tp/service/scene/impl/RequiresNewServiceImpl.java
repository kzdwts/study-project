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

//    场景一：外围方法未开启事务
//    通过这两个方法我们证明了在外围方法未开启事务的情况下Propagation.REQUIRES_NEW修饰
//    的内部方法会新开启自己的事务，且开启的事务相互独立，互不干扰

    /**
     * 验证方法一:
     * <p>
     * 数据库结果：“张三”插入，“李四”插入
     * <p>
     * 外围方法没有开启事务，插入“张三”、“李四”方法都在自己的事务中独立运行，外围方法抛出异常回滚不会影响内部方法
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
     * <p>
     * 数据库结果：“张三”插入，“李四”未插入
     * <p>
     * 外围方法没有开启事务，插入“张三”方法和插入“李四”方法分别开启自己的事务，插入“李四”方法抛出异常回滚
     * 其他事务不回滚
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
//    结论：在外围方法开启事务的情况下Propagation.REQUIRES_NEW修饰的内部方法依然会单独开启独立事务，
//    且与外部方法事务也独立。内部方法之间、内部方法和外部方法事务均相互独立，互不干扰

    /**
     * 验证方法一：
     * <p>
     * 数据库结果：“张三”未插入，“李四”插入，“王五”插入
     * <p>
     * 结果分析：外围方法开启事务，插入“张三”方法和外围方法一个事务，插入“李四”方法、
     * 插入“王五”方法分别在独立的新事务中，外围方法抛出异常只回滚和外围方法同一事务的方法，
     * 顾插入“张三”的方法回滚
     *
     * @author Kang Yong
     * @date 2023/2/18
     */
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

    /**
     * 验证方法二：
     * <p>
     * 数据库结果：“张三”未插入，“李四”插入，“王五”未插入
     * <p>
     * 结果分析：外围方法开启事务，插入“张三”方法和外围方法一个事务，插入“李四”方法、插入“王五”方法分别
     * 在独立的新建事务中。插入“王五”方法抛出异常，首先插入“王五”方法的事务被回滚，异常继续抛出被外围方法感知，
     * 外围方法事务亦被回滚，故插入“张三”方法也被回滚
     *
     * @author Kang Yong
     * @date 2023/2/19
     */
    @Transactional(propagation = Propagation.REQUIRED)
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

    /**
     * 验证方法三：
     * <p>
     * 数据库结果：“张三”插入，“李四”插入，“王五”未插入
     * <p>
     * 结果分析：外围方法开启事务，插入“张三”方法和外围方法一个事务，插入“李四”方法、插入“王五”方法分别
     * 在独立的新建事务中。插入“王五”方法抛出异常，首先插入“王五”方法的事务被回滚，异常被catch不会被外围方法感知，
     * 外围方法事务不回滚，故插入“张三”方法插入成功
     *
     * @author Kang Yong
     * @date 2023/2/19
     */
    @Transactional(propagation = Propagation.REQUIRED)
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
