package top.kangyong.study.redis.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * 品牌
 *
 * @author Kang Yong
 * @date 2022/9/29
 * @since 1.0.0
 */
@Data
public class Brand implements Serializable {

    private Integer id;
    private String name;
}
