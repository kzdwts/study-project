package top.kangyong.sentinelnew.stock.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 库存
 *
 * @author Kang Yong
 * @date 2023/1/15
 * @since 1.0.0
 */
@RestController
@RequestMapping("/stock")
public class StockController {


    @RequestMapping("/reduce")
    public String reduce() {
        return "减库存成功";
    }

}
