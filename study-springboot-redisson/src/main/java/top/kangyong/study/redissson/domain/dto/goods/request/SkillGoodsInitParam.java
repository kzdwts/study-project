package top.kangyong.study.redissson.domain.dto.goods.request;

import lombok.Data;

import java.io.Serializable;

/**
 * 商品
 *
 * @author Kang Yong
 * @date 2024/8/2
 * @since 1.0.0
 */
@Data
public class SkillGoodsInitParam implements Serializable {

    /**
     * 商品id
     */
    private Long goodsId;

    /**
     * 商品库存数量
     */
    private Integer goodsCount;
}
