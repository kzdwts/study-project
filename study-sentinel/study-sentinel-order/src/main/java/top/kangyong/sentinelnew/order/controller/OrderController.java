package top.kangyong.sentinelnew.order.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * order
 *
 * @author Kang Yong
 * @date 2023/1/11
 * @since 1.0.0
 */
@RestController
public class OrderController {

    @RequestMapping("/order/add")
    public String add() {
        return "Hello World";
    }

    @RequestMapping("/order/flow")
    @SentinelResource(value = "flow", blockHandler = "flowBlockHandler")
    public String flow() {
        return "flow正常访问";
    }

    @RequestMapping("/order/flowThread")
    @SentinelResource(value = "flowThread", blockHandler = "flowBlockHandler")
    public String flowThread() {
        return "flowThread正常访问";
    }

    public String flowBlockHandler(BlockException e) {
        e.printStackTrace();
        return "flow流控";
    }
}
