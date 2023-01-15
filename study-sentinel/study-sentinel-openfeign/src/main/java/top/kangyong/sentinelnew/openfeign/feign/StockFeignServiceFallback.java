package top.kangyong.sentinelnew.openfeign.feign;

import org.springframework.stereotype.Component;

/**
 * @author Kang Yong
 * @date 2023/1/16
 * @since 1.0.0
 */
@Component
public class StockFeignServiceFallback implements StockFeignService {

    @Override
    public String reduce() {
        return "降级啦！！！";
    }

}
