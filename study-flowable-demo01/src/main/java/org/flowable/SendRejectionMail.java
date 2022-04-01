package org.flowable;

import org.flowable.engine.delegate.DelegateExecution;
import org.flowable.engine.delegate.JavaDelegate;

/**
 * 执行
 *
 * @author Kang Yong
 * @date 2022/4/1
 * @since 1.0.0
 */
public class SendRejectionMail implements JavaDelegate {

    /**
     * 触发发送邮件的操作
     *
     * @param execution {@link DelegateExecution}
     * @author Kang Yong
     * @date 2022/4/1
     */
    @Override
    public void execute(DelegateExecution execution) {
        System.out.println("请假被拒绝，，，上课吧");
    }
}
