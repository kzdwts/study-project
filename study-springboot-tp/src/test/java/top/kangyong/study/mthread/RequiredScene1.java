package top.kangyong.study.mthread;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import top.kangyong.study.mthread.service.scene.RequiredService;

/**
 * 场景一
 * <p>
 * 此场景外围方法没有开启事务
 *
 * @author Kang Yong
 * @date 2023/2/13
 * @since 1.0.0
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class RequiredScene1 {

    @Autowired
    private RequiredService requiredService;

    @Test
    public void notransaction_exception_required_required() {
        requiredService.notransaction_exception_required_required();
    }

    @Test
    public void notransaction_required_required_exception() {
        requiredService.notransaction_required_required_exception();
    }

}
