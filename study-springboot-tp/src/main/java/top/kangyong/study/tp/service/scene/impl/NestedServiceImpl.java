package top.kangyong.study.tp.service.scene.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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

    @Override
    public void notransaction_exception_nested_nested() {

    }

    @Override
    public void notransaction_nested_nested_exception() {

    }

//    场景二：外围方法开启事务


    @Override
    public void transaction_exception_nested_nested() {

    }

    @Override
    public void transaction_nested_nested_exception() {

    }

    @Override
    public void transaction_nested_nested_exception_try() {

    }
}
