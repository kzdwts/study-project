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

    void notransaction_exception_requiresNew_requiresNew();

    void notransaction_requiresNew_requiresNew_exception();


//    场景二：外围方法开启事务

    void transaction_exception_required_requiresNew_requiresNew();

    void transaction_required_requiresNew_requiresNew_exception();

    void transaction_required_requiresNew_requiresNew_exception_try();

}
