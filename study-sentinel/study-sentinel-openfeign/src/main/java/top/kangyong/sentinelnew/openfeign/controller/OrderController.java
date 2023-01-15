package top.kangyong.sentinelnew.openfeign.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.kangyong.sentinelnew.openfeign.domain.Result;
import top.kangyong.sentinelnew.openfeign.feign.StockFeignService;


/**
 * 订单 控制层
 *
 * @author Kang Yong
 * @date 2023/1/15
 * @since 1.0.0
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private StockFeignService stockFeignService;

    @RequestMapping("/add")
    public Result add() {
        System.out.println("下单成功");
        String s = stockFeignService.reduce();

        String r = "Hello Feign " + s;
        return Result.success(r);
    }
}
