package top.kangyong.study.tp.service.scene;

/**
 * PROPAGATION_REQUIRES_NEW
 *
 * @author Kang Yong
 * @date 2023/2/15
 * @since 1.0.0
 */
public interface RequiresNewService {


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
    void notransaction_exception_requiresNew_requiresNew();

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
    void notransaction_requiresNew_requiresNew_exception();


//    场景二：外围方法开启事务

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
    void transaction_exception_required_requiresNew_requiresNew();

    void transaction_required_requiresNew_requiresNew_exception();

    void transaction_required_requiresNew_requiresNew_exception_try();

}
