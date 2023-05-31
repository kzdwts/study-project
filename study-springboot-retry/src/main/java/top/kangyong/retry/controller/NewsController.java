package top.kangyong.retry.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import top.kangyong.retry.service.NewsService;

/**
 * 新闻
 *
 * @author Kang Yong
 * @date 2023/5/31
 * @since 1.0.0
 */
@RestController
public class NewsController {

    @Autowired
    private NewsService newsService;

    /**
     * 获取新闻标题
     *
     * @param id {@link Long}
     * @return {@link Integer}
     * @author Kang Yong
     * @date 2023/5/31
     */
    @GetMapping("/news/info/{id}")
    public String getNewsTitle(@PathVariable(value = "id") Long id) throws Exception {
        return newsService.getNewsTitle(id);
    }
}
