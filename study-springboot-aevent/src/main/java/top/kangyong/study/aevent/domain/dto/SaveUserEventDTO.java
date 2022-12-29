package top.kangyong.study.aevent.domain.dto;

import lombok.ToString;
import org.springframework.context.ApplicationEvent;
import top.kangyong.study.aevent.domain.model.User;

/**
 * 保存用户 event
 *
 * @author Kang Yong
 * @date 2022/12/29
 * @since 1.0.0
 */
@ToString
public class SaveUserEventDTO extends ApplicationEvent {

    private Integer userId;

    private String idNo;

    /**
     * Create a new {@code ApplicationEvent}.
     *
     * @param source the object on which the event initially occurred or with
     *               which the event is associated (never {@code null})
     */
    public SaveUserEventDTO(User source, Integer userId, String idNo) {
        super(source);
        this.userId = userId;
        this.idNo = idNo;
    }

    public Integer getUserId() {
        return userId;
    }

    public String getIdNo() {
        return idNo;
    }
}
