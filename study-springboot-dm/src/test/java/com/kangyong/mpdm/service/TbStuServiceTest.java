package com.kangyong.mpdm.service;

import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.kangyong.mpdm.domain.TbStu;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * test
 *
 * @author Kang Yong
 * @date 2024/5/26
 * @since 1.0.0
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class TbStuServiceTest {

    @Autowired
    private TbStuService stuService;

    @Test
    public void save() {
        TbStu stu = new TbStu();
        stu.setName("张三");
        stu.setAge(18);

        boolean b = stuService.save(stu);
        System.out.println("b = " + b);
    }

    @Test
    public void saveBatch() {
        List<TbStu> stuList = new ArrayList<>();

        for (int i = 110; i < 118; i++) {
            stuList.add(new TbStu("赵" + i, i));
        }

        boolean b = stuService.saveBatch(stuList);
        System.out.println("b = " + b);
    }

    @Test
    public void delete() {
        boolean b = stuService.removeById(1794432958633553921L);
        System.out.println("b = " + b);
    }

    @Test
    public void update() {
        TbStu stu = new TbStu();
        stu.setId(1794439473264214017L);
        stu.setName("张三三");
        stu.setAge(20);
        boolean b = stuService.updateById(stu);
        System.out.println("b = " + b);
    }



    @Test
    public void getOne() {
        TbStu stu = stuService.getOne(Wrappers.<TbStu>lambdaQuery()
                .eq(TbStu::getAge, 18)
        );
        String jsonStr = JSONUtil.toJsonStr(stu);
        System.out.println("jsonStr = " + jsonStr);
    }

    @Test
    public void list() {
        List<TbStu> list = stuService.list(Wrappers.<TbStu>lambdaQuery()
                .eq(TbStu::getAge, 18)
        );
        String jsonStr = JSONUtil.toJsonStr(list);
        System.out.println("jsonStr = " + jsonStr);
    }

    /**
     * 分页
     *
     * @author Kang Yong
     * @date 2024/5/26
     */
    @Test
    public void page() {
        IPage<TbStu> page = new Page<>(1, 6);
        stuService.page(page, null);

        System.out.println("JSONUtil.toJsonStr(page) = " + JSONUtil.toJsonStr(page));
    }

    @Test
    public void pageHelper() {

    }

}