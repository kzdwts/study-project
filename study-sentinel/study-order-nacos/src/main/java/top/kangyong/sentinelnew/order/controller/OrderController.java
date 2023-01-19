package top.kangyong.sentinelnew.order.controller;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.kangyong.sentinelnew.order.domain.Result;

import java.util.concurrent.TimeUnit;

/**
 * order controller
 *
 * @author Kang Yong
 * @date 2023/1/19
 * @since 1.0.0
 */
@RestController
public class OrderController {

    @RequestMapping("/order/flow")
    public Result flow() {
        return Result.success("flow正常访问");
    }

    @RequestMapping("/order/flowThread")
    public Result flowThread() throws InterruptedException {
        TimeUnit.SECONDS.sleep(2);
        return Result.success("flowThread正常访问");
    }

    public String flowBlockHandler(BlockException e) {
        e.printStackTrace();
        return "flow流控";
    }

    @RequestMapping("/order/add")
    public Result add() {
        System.out.println("下单成功");
        return Result.success("生成订单");
    }

    @RequestMapping("/order/get")
    public Result get() {
        return Result.success("查询订单");
    }


    // 异常比例 降级

    @RequestMapping("/order/err")
    public Result err() {
        int i = 1 / 0;
        return Result.success("Hello World, err");
    }

    // 热点
    @RequestMapping("/order/get/{id}")
    public Result getById(@PathVariable("id") Integer id) {
        String msg = "正常访问";
        System.out.println(msg);
        return Result.success(msg);
    }


}
