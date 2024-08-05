package top.kangyong.study.redissson.domain.dto.goods.request;

import lombok.Data;

import java.io.Serializable;

/**
 * 秒杀
 *
 * @author Kang Yong
 * @date 2024/8/2
 * @since 1.0.0
 */
@Data
public class SkillGoodsParam implements Serializable {

    /**
     * 商品id
     */
    private Long goodsId;

    /**
     * 用户id
     */
    private String userName;

}
