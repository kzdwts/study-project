package top.kangyong.study.aevent.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Service;
import top.kangyong.study.aevent.domain.model.UserDetail;
import top.kangyong.study.aevent.mapper.UserDetailMapper;
import top.kangyong.study.aevent.service.UserDetailService;

/**
 * 用户详情
 *
 * @author Kang Yong
 * @date 2022/12/29
 * @since 1.0.0
 */
@Service
public class UserDetailServiceImpl implements UserDetailService {

    @Autowired
    private UserDetailMapper userDetailMapper;

    @Override
    public void insert(UserDetail userDetail) {
        userDetailMapper.insert(userDetail);
    }
}
