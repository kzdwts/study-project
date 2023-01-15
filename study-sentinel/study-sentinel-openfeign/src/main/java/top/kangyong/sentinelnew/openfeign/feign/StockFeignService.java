package top.kangyong.sentinelnew.openfeign.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 库存feign
 *
 * @author Kang Yong
 * @date 2023/1/15
 * @since 1.0.0
 */
@FeignClient(value = "study-sentinel-stock", path = "/stock")
public interface StockFeignService {

    @RequestMapping("/reduce")
    String reduce();
}
