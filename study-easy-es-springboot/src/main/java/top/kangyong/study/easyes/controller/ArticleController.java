package top.kangyong.study.easyes.controller;

import com.alibaba.fastjson.JSON;
import org.apache.commons.lang3.StringUtils;
import org.dromara.easyes.core.biz.EsPageInfo;
import org.dromara.easyes.core.conditions.select.LambdaEsQueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.kangyong.study.easyes.mapper.ArticleMapper;
import top.kangyong.study.easyes.model.Article;
import top.kangyong.study.easyes.request.ArticleSelectParam;

import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;

/**
 * 文章
 *
 * @author Kang Yong
 * @date 2024/2/1
 * @since 1.0.0
 */
@RestController
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private ArticleMapper articleMapper;

    @PostMapping("/insert")
    public Integer insert(@RequestBody Article article) {
        article.setCreateTime(new Date());
        if (StringUtils.isNotBlank(article.getStageIdStr())) {
            article.setStageIdList(new HashSet<>(Arrays.asList(article.getStageIdStr().split(","))));
        }
        return articleMapper.insert(article);
    }

    @PostMapping("/deleteById")
    public Integer deleteById(@RequestParam Long id) {
        return articleMapper.deleteById(id);
    }

    @PostMapping("/deleteIndex")
    public Boolean deleteIndex(@RequestParam String indexName) {
        return articleMapper.deleteIndex(indexName);
    }


    @PostMapping("/refreshWithIndexName")
    public Integer refreshWithIndexName(@RequestParam String indexName) {
        return articleMapper.refresh(indexName);
    }

    @PostMapping("/refresh")
    public Integer refresh() {
        return articleMapper.refresh();
    }

    @PostMapping("/pageInfo")
    public EsPageInfo<Article> getPageInfo(@RequestBody ArticleSelectParam param) {

//        EsWrappers.lambdaChainQuery(articleMapper).
//        EsWrappers.lambdaQuery(Article.class).

        LambdaEsQueryWrapper<Article> wrapper = new LambdaEsQueryWrapper<>();
        wrapper
                .eq(Objects.nonNull(param.getId()), Article::getId, param.getId())
                .match(StringUtils.isNotBlank(param.getTitle()), Article::getTitle, param.getTitle())
                .match(StringUtils.isNotBlank(param.getContent()), Article::getContent, param.getContent())
                .match(StringUtils.isNotBlank(param.getDesc()), Article::getDesc, param.getDesc())
                .match(StringUtils.isNotBlank(param.getAuthor()), Article::getAuthor, param.getAuthor())
                .eq(StringUtils.isNotBlank(param.getProjectId()), Article::getProjectId, param.getProjectId())
        // 测试用Set<String> 字段，in查询。结论可以实现
//                .in(StringUtils.isNotBlank(param.getStageId()), Article::getStageIdList, param.getStageId())
        ;

        EsPageInfo<Article> esPageInfo = articleMapper.pageQuery(wrapper, param.getPageNum(), param.getPageSize());
        System.out.println("JSON.toJSONString(esPageInfo) = " + JSON.toJSONString(esPageInfo));

        return esPageInfo;
    }


}
