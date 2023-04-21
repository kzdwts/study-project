package top.kangyong.sbsj;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import top.kangyong.sbsj.domain.entity.Customer;
import top.kangyong.sbsj.mapper.CustomerMapper;

/**
 * 测试 sharding-jdbc实现垂直分库
 *
 * @author Kang Yong
 * @date 2023/4/21
 * @since 1.0.0
 */
@SpringBootTest
@RunWith(SpringRunner.class)
@ActiveProfiles(value = "local3")
public class SbsjApplicationTestLocal3 {

    @Autowired
    private CustomerMapper customerMapper;

    @Test
    public void addOrdersDB() {
        for (int i = 1; i < 10; i++) {
            Customer customer = new Customer();
            customer.setId(i * 1L);
            customer.setName("zs" + i);

            customerMapper.insertCustomer(customer);
        }

        System.out.println("ADD NEW ORDER SUCCESS");
    }

}
