package top.kangyong.sbsj;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import top.kangyong.sbsj.domain.entity.Orders;
import top.kangyong.sbsj.mapper.OrdersMapper;

import java.util.Date;

/**
 * 测试水平分表
 *
 * @author Kang Yong
 * @date 2023/4/21
 * @since 1.0.0
 */
@SpringBootTest
@RunWith(SpringRunner.class)
@ActiveProfiles(value = "local1")
public class SbsjApplicationTestLocal1 {

    @Autowired
    private OrdersMapper ordersMapper;

    @Test
    public void addOrders() {
        for (int i = 10; i < 20; i++) {
            Orders orders = new Orders();
            orders.setId(i * 1L);
            orders.setOrderType(i);
            orders.setCustomerId(i);
            orders.setAmount(1000.0 * i);
            orders.setCreateTime(new Date());

            ordersMapper.insert(orders);
        }

        System.out.println("ADD NEW ORDER SUCCESS");
    }

    @Test
    public void queryOrders() {
        Orders orders = ordersMapper.selectOne(11);
        System.out.println("orders = " + orders);
    }

}
