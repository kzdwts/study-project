package top.kangyong.study.redis.service;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * test
 *
 * @author Kang Yong
 * @date 2022/11/29
 * @since 1.0.0
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class ClueServiceTest {

    @Autowired
    private ClueService clueService;

    @Test
    public void initDataList() {
        List<Integer> ids = new ArrayList<>(5);
        ids.add(1);
        ids.add(2);
        ids.add(3);
        ids.add(4);
        ids.add(5);

        clueService.initDataList(ids);

        System.out.println("操作成功");
    }

    @Test
    public void getDataList() {
        List<Integer> dataList = clueService.getDataList();
        dataList.forEach(System.out::println);
    }

    @Test
    public void getOne() {
        for (int i = 1; i <= 10; i++) {
            System.out.println("====第 " + i + " 次====");
            Integer one = clueService.getOne();
            System.out.println("==获取到lpop：" + one);
            clueService.add(one);
            List<Integer> dataList = clueService.getDataList();
            System.out.println(dataList);
        }
    }
}