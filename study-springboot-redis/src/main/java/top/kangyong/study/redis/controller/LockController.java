package top.kangyong.study.redis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
import top.kangyong.study.redis.util.RedisLockUtils;

/**
 * lock controller
 *
 * @author Kang Yong
 * @date 2023/3/15
 * @since 1.0.0
 */
@RestController
public class LockController {

    @Autowired
    private RedisLockUtils redisLockUtils;

    @GetMapping("/lock")
    public Mono<String> lock() {
        boolean success = redisLockUtils.acquireLock("test_lock", 60);
        if (success) {
            return Mono.just("get lock successfully");
        } else {
            return Mono.just("fail to get lock");
        }
    }
}
