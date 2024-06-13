package com.kangyong.springboot.mpt.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.kangyong.springboot.mpt.domain.model.ApArticle;
import com.kangyong.springboot.mpt.domain.param.ArticleParam;
import com.kangyong.springboot.mpt.domain.vo.ArticleVO;

import java.util.List;

/**
 * @author kangy
 * @description 针对表【ap_article(文章信息表，存储已发布的文章)】的数据库操作Mapper
 * @createDate 2024-06-13 14:02:37
 * @Entity generator.domain.ApArticle
 */
public interface ApArticleMapper extends BaseMapper<ApArticle> {

    List<ArticleVO> getArticlePage(ArticleParam param);
}




