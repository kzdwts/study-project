package top.kangyong.study.tp.service.scene;

/**
 * nested
 *
 * @author Kang Yong
 * @date 2023/2/16
 * @since 1.0.0
 */
public interface NestedService {

//    场景一：此场景外围方法没有开启事务

    void notransaction_exception_nested_nested();

    void notransaction_nested_nested_exception();

//  场景二：外围方法开启事务

    void transaction_exception_nested_nested();


    void transaction_nested_nested_exception();


    void transaction_nested_nested_exception_try();

}
