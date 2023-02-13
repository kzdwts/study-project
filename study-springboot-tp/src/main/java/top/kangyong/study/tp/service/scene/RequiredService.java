package top.kangyong.study.tp.service.scene;

/**
 * PROPAGATION_REQUIRED
 *
 * @author Kang Yong
 * @date 2023/2/13
 * @since 1.0.0
 */
public interface RequiredService {

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
}
