package top.kangyong.sbsj.mapper;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import top.kangyong.sbsj.domain.entity.Orders;

/**
 * Orders Dao
 *
 * @author Kang Yong
 * @date 2023/4/21
 * @since 1.0.0
 */
@Repository
@Mapper
public interface OrdersMapper {

    /**
     * 功能: 新增订单
     *
     * @param orders {@link Orders}
     * @author Kang Yong
     * @date 2023/4/21
     */
    @Insert("INSERT INTO orders(id, order_type, customer_id, amount) VALUES(#{id}, #{orderType}, #{customerId}, #{amount})")
    void insert(Orders orders);

    /**
     * 功能: 根据订单id查询详情
     *
     * @param id {@link Integer}
     * @return {@link Orders}
     * @author Kang Yong
     * @date 2023/4/21
     */
    @Select("SELECT * FROM orders WHERE id=#{id} AND delete_flag=0")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "orderType", column = "order_type"),
            @Result(property = "customerId", column = "customer_id"),
            @Result(property = "amount", column = "amount")
    })
    Orders selectOne(Integer id);

    /**
     * 功能: 根据订单id和客户id查询订单信息
     *
     * @param orders {@link Orders}
     * @return {@link Orders}
     * @author Kang Yong
     * @date 2023/4/21
     */
    @Select("SELECT * FROM orders WHERE id=#{id} AND customer_id=#{customerId} AND delete_flag=0")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "orderType", column = "order_type"),
            @Result(property = "customerId", column = "customer_id"),
            @Result(property = "amount", column = "amount")
    })
    Orders selectOneDB(Orders orders);

}
