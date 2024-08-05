package top.kangyong.study.redissson.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.kangyong.study.redissson.domain.dto.goods.request.SkillGoodsInitParam;
import top.kangyong.study.redissson.domain.dto.goods.request.SkillGoodsParam;
import top.kangyong.study.redissson.service.GoodsService;

/**
 * 商品秒杀
 *
 * @author Kang Yong
 * @date 2024/8/2
 * @since 1.0.0
 */
@RestController
@RequestMapping("/mall")
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    @PostMapping("/init")
    public boolean initGoods(@RequestBody SkillGoodsInitParam param) {
        return goodsService.initGoods(param);
    }

    @PostMapping("/skillGoods1")
    public boolean skillGoods1(@RequestBody SkillGoodsParam param) {
        return goodsService.skillGoods1(param);
    }

    @PostMapping("/skillGoods2")
    public boolean skillGoods2(@RequestBody SkillGoodsParam param) {
        return goodsService.skillGoods2(param);
    }

    @PostMapping("/skillGoods3")
    public boolean skillGoods3(@RequestBody SkillGoodsParam param) {
        return goodsService.skillGoods3(param);
    }

    @PostMapping("/skillGoods4")
    public boolean skillGoods4(@RequestBody SkillGoodsParam param) {
        return goodsService.skillGoods4(param);
    }

    @PostMapping("/skillGoods5")
    public boolean skillGoods5(@RequestBody SkillGoodsParam param) {
        return goodsService.skillGoods5(param);
    }

    @PostMapping("/skillGoods6")
    public boolean skillGoods6(@RequestBody SkillGoodsParam param) {
        return goodsService.skillGoods6(param);
    }

    @PostMapping("/skillGoods7")
    public boolean skillGoods7(@RequestBody SkillGoodsParam param) {
        return goodsService.skillGoods7(param);
    }

    @PostMapping("/skillGoods8")
    public boolean skillGoods8(@RequestBody SkillGoodsParam param) {
        return goodsService.skillGoods8(param);
    }

    @PostMapping("/skillGoods9")
    public boolean skillGoods9(@RequestBody SkillGoodsParam param) {
        return goodsService.skillGoods9(param);
    }

    @PostMapping("/skillGoods10")
    public boolean skillGoods10(@RequestBody SkillGoodsParam param) {
        return goodsService.skillGoods10(param);
    }

}
