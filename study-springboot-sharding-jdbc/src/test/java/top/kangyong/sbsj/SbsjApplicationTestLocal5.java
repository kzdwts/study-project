package top.kangyong.sbsj;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import top.kangyong.sbsj.domain.entity.Person;
import top.kangyong.sbsj.mapper.PersonMapper;

/**
 * 测试 sharding-jdbc 公共表
 *
 * @author Kang Yong
 * @date 2023/4/21
 * @since 1.0.0
 */
@SpringBootTest
@RunWith(SpringRunner.class)
@ActiveProfiles(value = "local5")
public class SbsjApplicationTestLocal5 {

    @Autowired
    private PersonMapper personMapper;

    @Test
    public void insertPerson() {
        Person person = new Person();
        person.setId(1L);
        person.setName("叶佳(15665336229)");

        System.out.println("ADD NEW dict_order_type SUCCESS");
    }

    @Test
    public void queryPerson() {
        Person person = personMapper.queryPerson(1L);
        System.out.println("person = " + person);
    }

}
