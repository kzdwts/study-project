package top.kangyong.study.mthread.service.scene;

/**
 * nested
 *
 * @author Kang Yong
 * @date 2023/2/16
 * @since 1.0.0
 */
public interface NestedService {

//    场景一：此场景外围方法没有开启事务

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
    void notransaction_exception_nested_nested();

    /**
     * 验证方法二
     * <p>
     * 数据库结果：“张三”插入，“李四”未插入
     * <p>
     * 结果分析：外围方法未开启事务，插入“张三”、“李四”方法在自己的事务中独立运行，
     * 所以插入”李四“方法抛出异常只会回滚插入”李四“方法插入“张三“方法不受影响
     */
    void notransaction_nested_nested_exception();

//  场景二：外围方法开启事务

    /**
     * 验证方法一
     * <p>
     * 数据库结果：“张三”,“李四”未均插入
     * <p>
     * 结果分析：外围方法开启事务，内部事务为外围事务的子事务，外围方法回滚，内部方法也要回滚
     */
    void transaction_exception_nested_nested();

    /**
     * 验证方法二
     * <p>
     * 数据库结果：“张三”,“李四”未均插入
     * <p>
     * 结果分析：外围方法开启事务，内部事务为外围事务的子事务，内部方法抛出异常回滚，
     * 且外围方法感知异常致使整体事务回滚
     */
    void transaction_nested_nested_exception();

    /**
     * 验证方法三
     * <p>
     * 数据库结果：“张三”插入,“李四”未插入
     * <p>
     * 结果分析：外围方法开启事务，内部事务为外围事务的子事务，
     * 插入“李四”内部方法抛出异常，可以单独对子事务回滚
     */
    void transaction_nested_nested_exception_try();

}
