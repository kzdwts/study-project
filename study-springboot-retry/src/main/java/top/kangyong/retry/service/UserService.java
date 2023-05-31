package top.kangyong.retry.service;

/**
 * 用户业务
 *
 * @author Kang Yong
 * @date 2023/5/20
 * @since 1.0.0
 */
public interface UserService {

    /**
     * 获取用户数量
     *
     * @param code {@link Integer}
     * @return {@link Integer}
     * @author Kang Yong
     * @date 2023/5/20
     */
    Integer getUserCount(Integer code) throws Exception;

}
