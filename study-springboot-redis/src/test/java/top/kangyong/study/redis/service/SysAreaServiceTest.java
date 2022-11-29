package top.kangyong.study.redis.service;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import top.kangyong.study.redis.domain.model.SysArea;

/**
 * test
 *
 * @author Kang Yong
 * @date 2022/9/29
 * @since 1.0.0
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class SysAreaServiceTest {

    @Autowired
    private SysAreaService sysAreaService;

    @Test
    public void getAreaByCode() {
        SysArea sysArea = sysAreaService.getAreaByCode(110100);
        SysArea sysArea2 = sysAreaService.getAreaByCode(110100);
        System.out.println(sysArea);
        System.out.println(sysArea2);

        SysArea sysArea3 = sysAreaService.getAreaByCode(340100);
        System.out.println(sysArea3);

        SysArea sysArea4 = sysAreaService.getAreaByCode(123456);
        System.out.println(sysArea4);
    }
}
