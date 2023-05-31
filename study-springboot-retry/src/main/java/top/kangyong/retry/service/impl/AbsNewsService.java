package top.kangyong.retry.service.impl;

import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import top.kangyong.retry.service.NewsService;

import java.time.LocalTime;

/**
 * 抽象
 *
 * @author Kang Yong
 * @date 2023/5/31
 * @since 1.0.0
 */
public abstract class AbsNewsService implements NewsService {

    /**
     * 功能: 查询新闻标题
     *
     * @param id {@link Long}
     * @return {@link String}
     * @author Kang Yong
     * @date 2023/5/31
     */
    // 实践证明在抽象类里面这个不起作用，不会进行重试操作
    @Retryable(value = Exception.class, maxAttempts = 3, backoff = @Backoff(delay = 2000, multiplier = 1.5))
    String getTitleById(Long id) throws Exception {
        System.out.println("AbsNewsService[getTitleById] 被调用：" + LocalTime.now());

        if (id == 0) {
            throw new Exception("情况不对头！参数错误：id=" + id);
        }

        System.out.println("AbsNewsService[getTitleById] 被正常调用，情况对头了！" + LocalTime.now());

        return "在我心中你最美";
    }

}
