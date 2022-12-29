package top.kangyong.study.aevent.service;

import top.kangyong.study.aevent.domain.model.UserDetail;

/**
 * 用户详情
 *
 * @author Kang Yong
 * @date 2022/12/29
 * @since 1.0.0
 */
public interface UserDetailService {

    /**
     * 新增用户详情
     *
     * @param userDetail {@link UserDetail}
     * @author Kang Yong
     * @date 2022/12/29
     */
    void insert(UserDetail userDetail);
}
