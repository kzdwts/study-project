package top.kangyong.retry.domain;

import lombok.Data;
import lombok.ToString;

/**
 * user
 *
 * @author Kang Yong
 * @date 2023/5/30
 * @since 1.0.0
 */
@Data
@ToString
public class User {

    private Long id;
    private String name;
    private Integer gender;
    private String birthday;

}
