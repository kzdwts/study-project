package top.kangyong.springboot.property.config;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Map;

/**
 * test
 *
 * @author Kang Yong
 * @date 2023/5/19
 * @since 1.0.0
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class ProvincePropertiesTest {

    @Autowired
    private ProvinceProperties provinceProperties;

    @Test
    public void show() {
        Map<Integer, String> provinceMap = provinceProperties.getProvinceMap();

        System.out.println("provinceMap.size() = " + provinceMap.size());

    }

}
