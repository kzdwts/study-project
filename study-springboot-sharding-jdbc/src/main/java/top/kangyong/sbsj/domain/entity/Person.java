package top.kangyong.sbsj.domain.entity;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * person
 *
 * @author Kang Yong
 * @date 2023/4/21
 * @since 1.0.0
 */
@Data
@ToString
public class Person implements Serializable {

    private Long id;
    private String name;

}
