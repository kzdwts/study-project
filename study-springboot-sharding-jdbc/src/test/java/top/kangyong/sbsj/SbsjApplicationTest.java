package top.kangyong.sbsj;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import top.kangyong.sbsj.domain.entity.Orders;
import top.kangyong.sbsj.mapper.OrdersMapper;

import java.util.Date;

/**
 * @author Kang Yong
 * @date 2023/4/21
 * @since 1.0.0
 */
@SpringBootTest
public class SbsjApplicationTest {

    @Autowired
    private OrdersMapper ordersMapper;

    @Test
    public void addOrders() {
        for (int i = 1; i < 10; i++) {
            Orders orders = new Orders();
            orders.setId(i);
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
        Orders orders = ordersMapper.selectOne(1);
        System.out.println("orders = " + orders);
    }

}
