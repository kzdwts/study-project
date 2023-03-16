package top.kangyong.springboot.property.domain;

import lombok.Data;
import lombok.ToString;

/**
 * cat
 *
 * @author Kang Yong
 * @date 2023/3/16
 * @since 1.0.0
 */
@ToString
@Data
public class Cat {

    private String typeName;

    private String color;

    private String name;

    private Integer age;
}
