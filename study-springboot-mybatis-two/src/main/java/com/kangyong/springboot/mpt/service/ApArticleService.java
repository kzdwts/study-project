package com.kangyong.springboot.mpt.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.kangyong.springboot.mpt.domain.model.ApArticle;
import com.kangyong.springboot.mpt.domain.param.ArticleParam;
import com.kangyong.springboot.mpt.domain.vo.ArticleVO;

import java.util.List;

/**
 * @author kangy
 * @description 针对表【ap_article(文章信息表，存储已发布的文章)】的数据库操作Service
 * @createDate 2024-06-13 14:02:37
 */
public interface ApArticleService extends IService<ApArticle> {

    /**
     * 根据条件查询
     *
     * @param param {@link ArticleParam}
     * @return {@link Page< ArticleVO>}
     * @author Kang Yong
     * @date 2024/6/13
     */
    List<ArticleVO> getArticlePage(ArticleParam param);
}
