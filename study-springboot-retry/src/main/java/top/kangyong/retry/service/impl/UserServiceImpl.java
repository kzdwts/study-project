package top.kangyong.retry.service.impl;

import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;
import top.kangyong.retry.service.UserService;

import java.time.LocalTime;

/**
 * 用户业务实现层
 *
 * @author Kang Yong
 * @date 2023/5/20
 * @since 1.0.0
 */
@Service
public class UserServiceImpl implements UserService {


    /**
     * Retryable:
     *  value: 指定抛出异常才会重试
     *  include：和value一样，默认为空，当exclude也为空时，默认所有异常
     *  exclude：指定不处理的异常
     *  maxAttempts：最大重试次数，默认3次
     *  backoff：等待重试策略，
     *      默认使用@Backoff，@Backoff的value默认为1000L，我们设置为2000；以毫秒为单位的延迟（默认 1000）
     *      multiplier（指定延迟背书）默认为0，标识固定暂停1秒后进行重试，如果把multiplier设置为1.5，则第一次重试为2秒，第二次为3秒，第三次为4.5秒
     *
     * @param code {@link Integer}
     * @return {@link Integer}
     * @author Kang Yong
     * @date 2023/5/21
     */
    @Override
    @Retryable(value = Exception.class, maxAttempts = 3, backoff = @Backoff(delay = 2000, multiplier = 1.5))
    public Integer getUserCount(Integer code) throws Exception {
        System.out.println("UserServiceImpl[getUserCount] 被调用：" + LocalTime.now());

        if (code == 0) {
            throw new Exception("情况不对头！");
        }

        System.out.println("UserServiceImpl[getUserCount] 被正常调用，情况对头了！" + LocalTime.now());

        return 200;
    }

    @Recover
    public int getUserCountRecover(Exception e, int code) {
        System.out.println("回调方法执行！！！");

        System.out.println("异常信息：" + e.getMessage());
        return 400;
    }

}
