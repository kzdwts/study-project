package top.kangyong.asyncdemo.service;

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
}
