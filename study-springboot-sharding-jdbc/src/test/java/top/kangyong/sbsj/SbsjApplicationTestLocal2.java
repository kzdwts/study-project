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
import java.util.Random;

/**
 * 测试 水平分库
 *
 * @author Kang Yong
 * @date 2023/4/21
 * @since 1.0.0
 */
@SpringBootTest
@RunWith(SpringRunner.class)
@ActiveProfiles(value = "local2")
public class SbsjApplicationTestLocal2 {

    @Autowired
    private OrdersMapper ordersMapper;

    @Test
    public void addOrdersDB() {
        for (int i = 1; i < 10; i++) {
            Orders orders = new Orders();
            orders.setId(i * 1L);
            orders.setOrderType(i);
            orders.setCustomerId(new Random().nextInt(10));
            orders.setAmount(1000.0 * i);
            orders.setCreateTime(new Date());

            ordersMapper.insert(orders);
        }

        System.out.println("ADD NEW ORDER SUCCESS");
    }

    @Test
    public void queryOrdersDB() {
        Orders orders = new Orders();
        orders.setCustomerId(7);
        orders.setId(7 * 1L);

        Orders o = ordersMapper.selectOneDB(orders);

        System.out.println("o = " + o);
    }

}
