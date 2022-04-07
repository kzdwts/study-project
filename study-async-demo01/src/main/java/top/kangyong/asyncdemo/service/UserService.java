package top.kangyong.asyncdemo.service;

import org.springframework.scheduling.annotation.AsyncResult;

import java.util.concurrent.Future;

/**
 * 用户
 *
 * @author Kang Yong
 * @date 2022/4/7
 * @since 1.0.0
 */
public interface UserService {

    /**
     * sync 更新用户
     *
     * @author Kang Yong
     * @date 2022/4/7
     */
    void syncUser();

    /**
     * async 更新用户
     *
     * @author Kang Yong
     * @date 2022/4/7
     */
    void asyncUser();

    /**
     * 异步 更新用户，如果调用了回调方法 则变为同步
     *
     * @return {@link Future< String>}
     * @author Kang Yong
     * @date 2022/4/7
     */
    Future<String> autoAsyncUser1();

    /**
     * 异步 更新用户，如果调用了回调方法 则变为同步
     *
     * @return {@link AsyncResult< String>}
     * @author Kang Yong
     * @date 2022/4/7
     */
    AsyncResult<String> autoAsyncUser2();

}
