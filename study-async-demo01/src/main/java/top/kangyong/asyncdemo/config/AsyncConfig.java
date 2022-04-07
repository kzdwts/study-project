package top.kangyong.asyncdemo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * async配置
 *
 * @author Kang Yong
 * @date 2022/4/7
 * @since 1.0.0
 */
@EnableAsync
@Configuration // 如果放在配置类上面，这两个要同时存在才会起作用
public class AsyncConfig {
}
