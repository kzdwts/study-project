package com.kangyong.springboot.mpt.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kangyong.springboot.mpt.domain.model.ApArticle;
import com.kangyong.springboot.mpt.domain.param.ArticleParam;
import com.kangyong.springboot.mpt.domain.vo.ArticleVO;
import com.kangyong.springboot.mpt.mapper.ApArticleMapper;
import com.kangyong.springboot.mpt.service.ApArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author kangy
 * @description 针对表【ap_article(文章信息表，存储已发布的文章)】的数据库操作Service实现
 * @createDate 2024-06-13 14:02:37
 */
@Service
public class ApArticleServiceImpl extends ServiceImpl<ApArticleMapper, ApArticle>
        implements ApArticleService {

    @Autowired
    private ApArticleMapper apArticleMapper;

    @Override
    public List<ArticleVO> getArticlePage(ArticleParam param) {

        return apArticleMapper.getArticlePage(param);
    }
}




