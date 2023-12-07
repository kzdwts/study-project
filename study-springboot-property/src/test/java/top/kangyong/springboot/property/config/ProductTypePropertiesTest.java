package top.kangyong.springboot.property.config;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
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

    /**
     * 测试修改配置文件的文件信息
     * <p>
     * 目前是没有问题，如果有并发，同时修改这个变量，会有问题（报错ArrayIndexOutOfBoundsException）
     *
     * @author Kang Yong
     * @date 2023/12/7
     */
    @Test
    public void testChangeProductTypeListData() {
        System.out.println("START");
        List<String> productTypeList = productTypeProperties.getProductTypeList();

        System.out.println("productTypeList.size() = " + productTypeList.size());
        productTypeList.forEach(System.out::println);

        // 新的
        List<String> tempList = new ArrayList<>();
        tempList.add("111");
//        tempList.add("050108");

        productTypeList.retainAll(tempList);

        System.out.println("productTypeList.size() = " + productTypeList.size());
        System.out.println("tempList.size() = " + tempList.size());
    }

}