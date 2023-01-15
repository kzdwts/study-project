package top.kangyong.sentinelnew.order.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.kangyong.sentinelnew.order.domain.Result;
import top.kangyong.sentinelnew.order.service.IOrderService;

import java.util.concurrent.TimeUnit;

/**
 * order
 *
 * @author Kang Yong
 * @date 2023/1/11
 * @since 1.0.0
 */
@RestController
public class OrderController {

//    @RequestMapping("/order/add")
//    public String add() {
//        return "Hello World";
//    }


    //    @SentinelResource(value = "flow", blockHandler = "flowBlockHandler") 这里不使用了，使用继承BlockExceptionHandler，统一的拦截，如果需要特殊处理，才用这个注解
    @RequestMapping("/order/flow")
    public Result flow() {
        return Result.success("flow正常访问");
    }

    @RequestMapping("/order/flowThread")
//    @SentinelResource(value = "flowThread", blockHandler = "flowBlockHandler")
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


    // 关联流控

    @Autowired
    private IOrderService orderService;

    @RequestMapping("/order/test1")
    public Result test1() {
        System.out.println("test1执行了");
        return Result.success(orderService.getUser(1));
    }

    @RequestMapping("/order/test2")
    public Result test2() {
        System.out.println("test2执行了===");
        return Result.success(orderService.getUser(2));
    }

    // 异常比例 降级

    @RequestMapping("/order/err")
    public Result err() {
        int i = 1 / 0;
        return Result.success("Hello World, err");
    }
}
