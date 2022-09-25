package top.kangyong.study.redis.service;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import top.kangyong.study.redis.domain.Brand;

/**
 * test
 *
 * @author Kang Yong
 * @date 2022/9/25
 * @since 1.0.0
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class BrandServiceTest {

    @Autowired
    private BrandService brandService;

    @Test
    public void testGet() {
        System.out.println("start===");
        Brand brand = brandService.getByBrandId(11);
        System.out.println(brand);
        System.out.println("end===");
    }

    @Test
    public void testGet2() {
        System.out.println("start===");
        String name = brandService.getNameById(11);
        System.out.println(name);
        System.out.println("end===");
    }

}