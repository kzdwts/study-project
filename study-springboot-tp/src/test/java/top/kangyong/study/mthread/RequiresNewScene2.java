package top.kangyong.study.mthread;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import top.kangyong.study.mthread.service.scene.RequiresNewService;

/**
 * Propagation.REQUIRES_NEW 场景二
 *
 * @author Kang Yong
 * @date 2023/2/17
 * @since 1.0.0
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class RequiresNewScene2 {

    @Autowired
    private RequiresNewService requiresNewService;

    public void transaction_exception_required_requiresNew_requiresNew() {
        requiresNewService.transaction_exception_required_requiresNew_requiresNew();
    }

    public void transaction_required_requiresNew_requiresNew_exception() {
        requiresNewService.transaction_required_requiresNew_requiresNew_exception();
    }

    public void transaction_required_requiresNew_requiresNew_exception_try() {
        requiresNewService.transaction_required_requiresNew_requiresNew_exception_try();
    }

}
