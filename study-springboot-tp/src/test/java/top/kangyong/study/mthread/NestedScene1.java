package top.kangyong.study.mthread;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import top.kangyong.study.mthread.service.scene.NestedService;

/**
 * test nested
 *
 * @author Kang Yong
 * @date 2023/2/20
 * @since 1.0.0
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class NestedScene1 {

    @Autowired
    private NestedService nestedService;

    @Test
    public void notransaction_exception_nested_nested() {
        nestedService.notransaction_exception_nested_nested();
    }

    @Test
    public void notransaction_nested_nested_exception() {
        nestedService.notransaction_nested_nested_exception();
    }

    @Test
    public void transaction_exception_nested_nested() {
        nestedService.transaction_exception_nested_nested();
    }

    @Test
    public void transaction_nested_nested_exception() {
        nestedService.transaction_nested_nested_exception();
    }

    @Test
    public void transaction_nested_nested_exception_try() {
        nestedService.transaction_nested_nested_exception_try();
    }

}
