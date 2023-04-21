package top.kangyong.sbsj.domain.entity;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * 订单
 *
 * @author Kang Yong
 * @date 2023/4/21
 * @since 1.0.0
 */
@Data
@ToString
public class Orders implements Serializable {
    /**
     * id
     */
    private Integer id;
    /**
     * 订单类型：
     */
    private Integer orderType;
    /**
     * 客户id
     */
    private Integer customerId;
    /**
     * 金额
     */
    private Double amount;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 修改时间
     */
    private Date modifyTime;
    /**
     * 删除标识：  0-正常；  1-删除
     */
    private Integer deleteFlag;
}
