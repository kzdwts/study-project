package top.kangyong.retry.service.impl;

import org.springframework.stereotype.Service;

/**
 * news 业务
 *
 * @author Kang Yong
 * @date 2023/5/31
 * @since 1.0.0
 */
@Service
public class NewsServiceImpl extends AbsNewsService {

    @Override
    public String getNewsTitle(Long id) throws Exception {
        System.out.println("NewsServiceImpl[getNewsTitle] 被调用了");

        String title = super.getTitleById(id);

        return title;
    }
}
