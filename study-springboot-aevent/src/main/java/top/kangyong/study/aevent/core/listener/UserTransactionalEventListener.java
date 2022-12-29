package top.kangyong.study.aevent.core.listener;

import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;
import top.kangyong.study.aevent.domain.dto.SaveUserEventDTO;

/**
 * 用户信息变更监听
 *
 * @author Kang Yong
 * @date 2022/12/29
 * @since 1.0.0
 */

@Component
public class UserTransactionalEventListener {

    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    public void userEventListener(SaveUserEventDTO eventDTO) {
        System.out.println("监听到用户数据变更：" + eventDTO.toString());
    }
}
