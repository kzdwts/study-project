package top.kangyong.study.tp.service.scene;

/**
 * PROPAGATION_REQUIRED
 *
 * @author Kang Yong
 * @date 2023/2/13
 * @since 1.0.0
 */
public interface RequiredService {

//    场景一：外围方法未开启事务

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
    void notransaction_exception_required_required();

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
    void notransaction_required_required_exception();

//    场景二：围方法开启事务

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
    void transaction_exception_required_required();

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
    void transaction_required_required_exception();

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
    void transaction_required_required_exception_try();

}
