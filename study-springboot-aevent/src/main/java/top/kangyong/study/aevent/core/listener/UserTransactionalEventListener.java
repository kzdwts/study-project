package top.kangyong.study.aevent.core.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;
import top.kangyong.study.aevent.domain.dto.SaveUserEventDTO;
import top.kangyong.study.aevent.domain.model.User;
import top.kangyong.study.aevent.domain.model.UserDetail;
import top.kangyong.study.aevent.service.UserDetailService;

/**
 * 用户信息变更监听
 *
 * @author Kang Yong
 * @date 2022/12/29
 * @since 1.0.0
 */
@Service
public class UserTransactionalEventListener {

    @Autowired
    private UserDetailService userDetailService;

    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    public void userEventListener(SaveUserEventDTO eventDTO) {
        System.out.println("监听到用户数据变更：" + eventDTO.toString());

        User source = (User) eventDTO.getSource();

        UserDetail userDetail = new UserDetail();
        userDetail.setUserId(eventDTO.getUserId());
        userDetail.setGender(0);
        userDetail.setAge(23);
        userDetail.setHome("");

        userDetailService.insert(userDetail);
        System.out.println("新增用户详情成功");

    }
}
