package top.kangyong.springboot.property.config;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Map;

/**
 * test
 *
 * @author Kang Yong
 * @date 2022/9/27
 * @since 1.0.0
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class MsgTemplatePropertiesTest {

    @Autowired
    private MsgTemplateProperties msgTemplateProperties;

    @Test
    public void showProperties() {
        System.out.println(msgTemplateProperties);

        // 读取配置文件list
        List<Map<String, String>> msgTemplateList = msgTemplateProperties.getMsgTemplateList();
        System.out.println(msgTemplateList.size());
    }

}
