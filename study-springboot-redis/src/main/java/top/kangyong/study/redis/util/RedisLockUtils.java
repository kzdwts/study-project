package top.kangyong.study.redis.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.util.UUID;

/**
 * redis 分布式锁工具类
 * <p>
 * 这里仅仅是一个demo，在实际的生产环境中，需要对分布式锁的过期时间、加锁失败时的重试机制等进行更加详细的设置
 *
 * @author Kang Yong
 * @date 2023/3/15
 * @since 1.0.0
 */
@Component
public class RedisLockUtils {

    private static final String LOCK_KEY_PREFIX = "redis_lock_";

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    /**
     * 获取分布式锁
     *
     * @param lockName      {@link String} 锁的名称
     * @param expireSeconds {@link long} 锁的过期时间（单位：秒）
     * @return {@link boolean} 是否获取到锁：true-是，false-否
     * @author Kang Yong
     * @date 2023/3/15
     */
    public boolean acquireLock(String lockName, long expireSeconds) {
        String lockKey = LOCK_KEY_PREFIX + lockName;
        String value = UUID.randomUUID().toString();

        Boolean success = redisTemplate.opsForValue().setIfAbsent(lockKey, value, Duration.ofSeconds(expireSeconds));
        return success != null && success;
    }

    /**
     * 释放分布式锁
     *
     * @param lockName {@link String} 锁的名称
     * @author Kang Yong
     * @date 2023/3/15
     */
    public void releaseLock(String lockName) {
        String lockKey = LOCK_KEY_PREFIX + lockName;
        redisTemplate.delete(lockKey);
    }

}
