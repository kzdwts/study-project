package top.kangyong.study.aevent.service;

import top.kangyong.study.aevent.domain.model.User;

/**
 * 用户业务
 *
 * @author Kang Yong
 * @date 2022/12/29
 * @since 1.0.0
 */
public interface UserService {

    /**
     * 根据id更新
     *
     * @param user {@link User}
     * @author Kang Yong
     * @date 2022/12/29
     */
    void updateById(User user);

    /**
     * 新增用户
     *
     * @param user {@link User}
     * @author Kang Yong
     * @date 2022/12/29
     */
    void insert(User user);
}
