package top.kangyong.springboot.property.util;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeanUtils;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import top.kangyong.springboot.property.domain.dto.Car;

import java.util.Date;

/**
 * @author Kang Yong
 * @date 2023/9/22
 * @since 2.0.0
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class CopyUtilTest {

    @Test
    public void testCopy1() {
        Car car1 = new Car(1, "大众", 18, null, new Date());
        Car car2 = new Car(null, "大众", null, "白色", null);

        BeanUtils.copyProperties(car1, car2);
        System.out.println("car1 = " + car1);
        System.out.println("car2 = " + car2);
    }

    @Test
    public void testCopy2() {
        Car car1 = new Car(1, "大众", 18, null, new Date());
        Car car2 = new Car(null, "大众", null, "白色", null);

        BeanUtil.copyProperties(car1, car2, CopyOptions.create().setIgnoreNullValue(true).setIgnoreError(true));
        System.out.println("car1 = " + car1);
        System.out.println("car2 = " + car2);
    }
}
