package top.kangyong.springboot.property.config;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * test
 *
 * @author Kang Yong
 * @date 2023/10/31
 * @since 1.0.0
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class ProductTypePropertiesTest {

    @Autowired
    private ProductTypeProperties productTypeProperties;


    @Test
    public void showProductTypeList() {
        System.out.println("START");
        List<String> productTypeList = productTypeProperties.getProductTypeList();

        System.out.println("productTypeList.size() = " + productTypeList.size());
        productTypeList.forEach(System.out::println);
    }

}