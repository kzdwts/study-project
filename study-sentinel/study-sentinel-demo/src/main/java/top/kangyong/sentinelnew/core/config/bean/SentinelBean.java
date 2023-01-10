package top.kangyong.sentinelnew.core.config.bean;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.annotation.aspectj.SentinelResourceAspect;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * 流控注解
 *
 * @author Kang Yong
 * @date 2023/1/10
 * @since 1.0.0
 */
@Component
public class SentinelBean {

    /**
     * 注解支持的配置bean
     *
     * @return {@link SentinelResourceAspect}
     * @author Kang Yong
     * @date 2023/1/10
     */
    @Bean
    public SentinelResourceAspect sentinelResourceAspect() {
        return new SentinelResourceAspect();
    }
}
