package top.kangyong.springboot.property.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

/**
 * 测试类：car
 *
 * @author Kang Yong
 * @date 2023/9/22
 * @since 2.0.0
 */
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Car {

    private Integer id;

    private String brand;

    private Integer age;

    private String color;

    private Date createTime;

}
