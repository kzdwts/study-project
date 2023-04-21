package top.kangyong.sbsj.domain.entity;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * 客户
 *
 * @author Kang Yong
 * @date 2023/4/21
 * @since 1.0.0
 */
@Data
@ToString
public class Customer implements Serializable {

    private Integer id;
    private String name;
}
