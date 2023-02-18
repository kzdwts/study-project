package top.kangyong.study.tp;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import top.kangyong.study.tp.service.scene.RequiresNewService;

/**
 * Propagation.REQUIRES_NEW 场景一
 *
 * @author Kang Yong
 * @date 2023/2/17
 * @since 1.0.0
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class RequiresNewScene1 {

    @Autowired
    private RequiresNewService requiresNewService;

    @Test
    public void notransaction_exception_requiresNew_requiresNew() {
        requiresNewService.notransaction_exception_requiresNew_requiresNew();
    }

    @Test
    public void notransaction_requiresNew_requiresNew_exception() {
        requiresNewService.notransaction_requiresNew_requiresNew_exception();
    }

}
