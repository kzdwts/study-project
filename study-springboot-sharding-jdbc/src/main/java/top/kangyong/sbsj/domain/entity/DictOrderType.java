package top.kangyong.sbsj.domain.entity;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * 字典
 *
 * @author Kang Yong
 * @date 2023/4/21
 * @since 1.0.0
 */
@Data
@ToString
public class DictOrderType implements Serializable {

    private Integer id;
    private String orderType;

}
