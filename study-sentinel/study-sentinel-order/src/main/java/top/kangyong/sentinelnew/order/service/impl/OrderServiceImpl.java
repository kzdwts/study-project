package top.kangyong.sentinelnew.order.service.impl;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.stereotype.Service;
import top.kangyong.sentinelnew.order.service.IOrderService;

/**
 * order 业务实现
 *
 * @author Kang Yong
 * @date 2023/1/14
 * @since 1.0.0
 */
@Service
public class OrderServiceImpl implements IOrderService {

    @Override
    @SentinelResource(value = "getUser", blockHandler = "blockHandlerGetUser")
    public String getUser(Integer id) {
        return "查询用户" + id;
    }

    public String blockHandlerGetUser(Integer id, BlockException e) {
        e.printStackTrace();
        return "流控用户" + id;
    }


}
