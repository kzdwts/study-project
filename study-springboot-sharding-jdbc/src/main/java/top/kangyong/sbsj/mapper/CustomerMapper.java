package top.kangyong.sbsj.mapper;

import org.apache.ibatis.annotations.Insert;
import org.springframework.stereotype.Repository;
import top.kangyong.sbsj.domain.entity.Customer;

/**
 * Customer Dao
 *
 * @author Kang Yong
 * @date 2023/4/21
 * @since 1.0.0
 */
@Repository
public interface CustomerMapper {

    /**
     * 功能:新增客户
     *
     * @param customer {@link Customer}
     * @author Kang Yong
     * @date 2023/4/21
     */
    @Insert("INSERT INTO customer(id, name) VALUES(#{id}, #{name})")
    void insertCustomer(Customer customer);

}
