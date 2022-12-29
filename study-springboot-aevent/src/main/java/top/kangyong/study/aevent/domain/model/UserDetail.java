package top.kangyong.study.aevent.domain.model;

import lombok.Data;

/**
 * 用户详情
 *
 * @author Kang Yong
 * @date 2022/12/29
 * @since 1.0.0
 */
@Data
public class UserDetail {

    private Integer userId;
    private Integer gender;
    private Integer age;
    private String home;

}
