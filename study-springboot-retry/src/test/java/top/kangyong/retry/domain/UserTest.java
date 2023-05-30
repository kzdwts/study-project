package top.kangyong.retry.domain;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import org.junit.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 *test
 *
 * @author Kang Yong
 * @date 2023/5/30
 * @since 1.0.0
 */
@SpringBootTest
public class UserTest {

    @Test
    public void testCopy() {
        User u1 = new User();
        u1.setId(1L);
        u1.setName("王丽丽");
        u1.setBirthday("2023年5月30日16:04:55");

        User u2 = new User();
        u2.setName("李子木");
        u2.setGender(0);
        u2.setBirthday("2001年5月30日16:04:55");

        BeanUtil.copyProperties(u2, u1, true, CopyOptions.create().setIgnoreNullValue(true).setIgnoreError(true));

        System.out.println("u1 = " + u1);

    }

}
