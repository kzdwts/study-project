package top.kangyong.study.tp.service.scene.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import top.kangyong.study.tp.domain.User1;
import top.kangyong.study.tp.domain.User2;
import top.kangyong.study.tp.service.scene.RequiredService;
import top.kangyong.study.tp.service.user.User1Service;
import top.kangyong.study.tp.service.user.User2Service;

/**
 * @author Kang Yong
 * @date 2023/2/13
 * @since 1.0.0
 */
@Service
public class RequiredServiceImpl implements RequiredService {

    @Autowired
    private User1Service user1Service;

    @Autowired
    private User2Service user2Service;

//    场景一（此场景外围方法没有开启事务）
//    结论：通过这两个方法我们证明了在外围方法未开启事务的情况下Propagation.REQUIRED修饰的内部方法
//    会新开启自己的事务，且开启的事务互相独立，互不干扰

    /**
     * 验证方法一：
     * <p>
     * 数据库结果：张三、李四 均插入
     * <p>
     * 结果分析：外围方法未开启事务，插入“张三”、“李四”方法在自己的事务中独立运行，
     * 外围方法异常不影响内部插入“张三”、“李四”方法独立的事务
     *
     * @author Kang Yong
     * @date 2023/2/13
     */
    @Override
    public void notransaction_exception_required_required() {
        User1 user1 = new User1();
        user1.setName("张三");
        user1Service.addRequired(user1);

        User2 user2 = new User2();
        user2.setName("李四");
        user2Service.addRequired(user2);

        throw new RuntimeException();
    }

    /**
     * 验证方法二：
     * <p>
     * 数据库结果：“张三”插入，“李四”未插入
     * <p>
     * 结果分析：外围方法没有事务，插入“张三”、“李四”的方法都在自己的事务中独立运行
     * 所以插入“李四”方法抛出异常只会回滚插入“李四”方法，
     * 插入“张三”方法不受印象
     *
     * @author Kang Yong
     * @date 2023/2/13
     */
    @Override
    public void notransaction_required_required_exception() {
        User1 user1 = new User1();
        user1.setName("张三");
        user1Service.addRequired(user1);

        User2 user2 = new User2();
        user2.setName("李四");
        user2Service.addRequiredException(user2);
    }


//    场景二（外围方法开启事务，这个是使用率比较高的场景）

    /**
     * 验证方法一：
     * <p>
     * 数据库结果：“张三”，“李四”均未插入
     * <p>
     * 结果分析：外围方法开启事务，内部方法加入外围方法事务，外围方法回滚，内部方法也要回滚
     *
     * @author Kang Yong
     * @date 2023/2/13
     */
    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void transaction_exception_required_required() {
        User1 user1 = new User1();
        user1.setName("张三");
        user1Service.addRequired(user1);

        User2 user2 = new User2();
        user2.setName("李四");
        user2Service.addRequired(user2);

        throw new RuntimeException();
    }

    /**
     * 验证方法二：
     * <p>
     * 数据库结果：“张三”，“李四”均未插入
     * <p>
     * 结果分析：外围方法开启事务，内部方法加入外围方法事务，内部方法抛出异常回滚，外部方法感知异常致使整体事务回滚
     *
     * @author Kang Yong
     * @date 2023/2/13
     */
    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void transaction_required_required_exception() {
        User1 user1 = new User1();
        user1.setName("张三");
        user1Service.addRequired(user1);

        User2 user2 = new User2();
        user2.setName("李四");
        user2Service.addRequiredException(user2);
    }

    /**
     * 验证方法三：
     * <p>
     * 数据库结果：“张三”，“李四”均未插入
     * <p>
     * 结果分析：外围方法开启事务，内部方法加入外围方法事务，内部方法抛出异常回滚，
     * 即使方法被catch不被外围方法感知，整个事务依然回滚
     *
     * @author Kang Yong
     * @date 2023/2/13
     */
    @Transactional // 默认事务传播行为 propagation = Propagation.REQUIRED
    @Override
    public void transaction_required_required_exception_try() {
        User1 user1 = new User1();
        user1.setName("张三");
        user1Service.addRequired(user1);

        User2 user2 = new User2();
        user2.setName("李四");
        try {
            user2Service.addRequiredException(user2);
        } catch (Exception e) {
            System.out.println("方法回滚");
        }
    }


}
