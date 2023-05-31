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
     * value: 指定抛出异常才会重试
     * include：和value一样，默认为空，当exclude也为空时，默认所有异常
     * exclude：指定不处理的异常
     * maxAttempts：最大重试次数，默认3次
     * backoff：等待重试策略，
     * 默认使用@Backoff，@Backoff的value默认为1000L，我们设置为2000；以毫秒为单位的延迟（默认 1000）
     * multiplier（指定延迟背书）默认为0，标识固定暂停1秒后进行重试，如果把multiplier设置为1.5，则第一次重试为2秒，第二次为3秒，第三次为4.5秒
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

    /**
     * Spring-Retry提供了@Recover注解，用于@Retryable重试失败后处理方法。
     * 如果不需要回调方法，可以直接不写回调方法，那么实现的效果是，重试次数完了后，如果还没有成功没符合业务判断，就抛出异常。
     * 可以看到传参里面写的是 Exception e,这个是作为回调的接头暗号（次数用完了，还是失败，我们抛出这个Exception e通知触发这个回调方法）。
     * <p>
     * 注意事项：
     * 方法的返回值必须与@Retryable方法一致
     * 方法的第一个参数，必须是Throwable类型的，建议是与@Retryable配置的异常一致，其他的参数，需要哪个参数，写进去就行了（@Retryable方法中有的）
     * 该回调方法与重试方法写在同一个类里面
     *
     * 犹豫是基于AOP实现，所以不支持类里自调用方法
     * 如果重试失败需要给@Recover注解的方法做后续处理，这个重试的方法不能有返回值，只能是void
     * 方法内不是使用 try-catch，只能往外抛异常
     * 使用@Recover注解来开启重试失败调用的方法（注意需要跟重试方法在同一个类中），
     *  此注解注释的方法参数一定要是@Retryable抛出的异常，否则无法识别，可以在该方法中进行日志处理
     *
     * @param e    {@link Exception}
     * @param code {@link Integer}
     * @return {@link Integer}
     * @author Kang Yong
     * @date 2023/5/22
     */
    @Recover
    public Integer getUserCountRecover(Exception e, Integer code) {
        System.out.println("回调方法执行！！！");
        System.out.println("code = " + code);
        System.out.println("异常信息：" + e.getMessage());
        return 400;
    }

}
