package top.kangyong.springboot.property.er;

import cn.hutool.core.util.NumberUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.Date;

/**
 * test
 *
 * @author Kang Yong
 * @date 2024/1/19
 * @since 1.0.0
 */
@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class LogErrorTest {


    @Test
    public void showLogInfo() {
        Date date = new Date();
        try {
            BigDecimal b1 = new BigDecimal(0);
            BigDecimal b2 = new BigDecimal(1);
            BigDecimal b3 = new BigDecimal(0);

            BigDecimal div = NumberUtil.div(b1, b2);
            log.info("LogErrorTest[showLogInfo],div={}", div);

            BigDecimal div2 = NumberUtil.div(b1, b3);
            log.info("LogErrorTest[showLogInfo],div2={}", div2);


        } catch (Exception e) {
            e.printStackTrace();
            log.info("LogErrorTest[showLogInfo],当前时间：{}，", date, e);
        }

    }


}
