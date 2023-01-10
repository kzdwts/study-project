package top.kangyong.sentinelnew.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 数据实体
 *
 * @author Kang Yong
 * @date 2023/1/9
 * @since 1.0.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {

    /**
     * 姓名
     */
    private String name;
}
