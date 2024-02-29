package top.kangyong.study.easyes.controller;


import com.alibaba.fastjson.JSON;
import lombok.RequiredArgsConstructor;
import org.dromara.easyes.core.biz.EsPageInfo;
import org.dromara.easyes.core.conditions.select.LambdaEsQueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import top.kangyong.study.easyes.mapper.DocumentMapper;
import top.kangyong.study.easyes.model.Document;

import java.util.List;

/**
 * 测试使用Easy-ES
 * <p>
 * Copyright © 2021 xpc1024 All Rights Reserved
 **/
@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class TestUseEeController {
    private final DocumentMapper documentMapper;

    @GetMapping("/createIndex")
    public Boolean createIndex() {
        // 1.初始化-> 创建索引(相当于mysql中的表)
        return documentMapper.createIndex();
    }

    @GetMapping("/insert")
    public Integer insert() {
        // 2.初始化-> 新增数据
        Document document = new Document();
        document.setId("111");
        document.setTitle("洪金宝");
        document.setContent("虹猫蓝兔七侠传");
        return documentMapper.insert(document);
    }

    @GetMapping("/search")
    public List<Document> search() {
        // 3.查询出所有标题为老汉的文档列表
        LambdaEsQueryWrapper<Document> wrapper = new LambdaEsQueryWrapper<>();
        wrapper.eq(Document::getTitle, "洪金宝");
        return documentMapper.selectList(wrapper);
    }

    @GetMapping("/pageInfo")
    public EsPageInfo<Document> pageInfo(@RequestParam("keywords") String keywords) {
        Integer pageNum = 1;
        Integer pageSize = 10;

        LambdaEsQueryWrapper<Document> wrapper = new LambdaEsQueryWrapper<>();
//        wrapper.eq(Document::getTitle, "洪金宝");
        wrapper.like(Document::getTitle, keywords);
        EsPageInfo<Document> pageInfo = documentMapper.pageQuery(wrapper, pageNum, pageSize);

        System.out.println("JSON.toJSONString(pageInfo) = " + JSON.toJSONString(pageInfo));
        return pageInfo;
    }

}
