package top.kangyong.study.aevent.domain.model;

import lombok.Data;
import lombok.ToString;

/**
 * 用户
 *
 * @author Kang Yong
 * @date 2022/12/29
 * @since 1.0.0
 */
@Data
@ToString
public class User {
    private Integer id;
    private String name;
    private String idNo;
    private String phone;
}
