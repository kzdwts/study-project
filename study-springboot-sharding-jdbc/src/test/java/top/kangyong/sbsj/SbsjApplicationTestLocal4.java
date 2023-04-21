package top.kangyong.sbsj;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import top.kangyong.sbsj.domain.entity.DictOrderType;
import top.kangyong.sbsj.mapper.DictOrderTypeMapper;

/**
 * 测试 sharding-jdbc 公共表
 *
 * @author Kang Yong
 * @date 2023/4/21
 * @since 1.0.0
 */
@SpringBootTest
@RunWith(SpringRunner.class)
@ActiveProfiles(value = "local4")
public class SbsjApplicationTestLocal4 {

    @Autowired
    private DictOrderTypeMapper dictOrderTypeMapper;

    @Test
    public void insertDictOrderType() {
        for (int i = 1; i < 10; i++) {
            DictOrderType dictOrderType = new DictOrderType();
            dictOrderType.setOrderType("orderType" + i);

            dictOrderTypeMapper.insertDictOrderType(dictOrderType);
        }

        System.out.println("ADD NEW dict_order_type SUCCESS");
    }

    @Test
    public void deleteDictOrderType() {
        dictOrderTypeMapper.deleteDictOrderType(1);
    }

}
