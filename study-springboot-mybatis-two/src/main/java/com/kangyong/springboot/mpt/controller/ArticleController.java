package com.kangyong.springboot.mpt.controller;

import com.kangyong.springboot.mpt.domain.param.ArticleParam;
import com.kangyong.springboot.mpt.domain.vo.ArticleVO;
import com.kangyong.springboot.mpt.service.ApArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 文章
 *
 * @author Kang Yong
 * @date 2024/6/13
 * @since 1.0.0
 */
@RestController
@RequestMapping("/mpt/article")
public class ArticleController {

    @Autowired
    private ApArticleService apArticleService;

    @PostMapping("/getArticlePage")
    public List<ArticleVO> getArticlePage(@RequestBody ArticleParam param) {
        List<ArticleVO> articleList = apArticleService.getArticlePage(param);
        return articleList;
    }
}
