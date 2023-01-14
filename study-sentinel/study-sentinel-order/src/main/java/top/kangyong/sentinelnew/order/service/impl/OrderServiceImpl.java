package top.kangyong.sentinelnew.order.service.impl;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
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
    @SentinelResource(value = "getUser")
    public String getUser() {
        return "查询用户";
    }
}
