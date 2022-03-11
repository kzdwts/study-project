package top.kangyong.study.redis.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.listener.KeyExpirationEventMessageListener;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.stereotype.Component;

/**
 * 监听redis key过期
 *
 * @author Kang Yong
 * @date 2022/3/11
 * @since 1.0.0
 */
@Slf4j
@Component
public class RedisKeyExpirationListener extends KeyExpirationEventMessageListener {

    public RedisKeyExpirationListener(RedisMessageListenerContainer listenerContainer) {
        super(listenerContainer);
    }

    @Override
    public void onMessage(Message message, byte[] pattern) {
        String expiredKey = message.toString();
        log.info("失效key：{}", expiredKey);

        byte[] body = message.getBody();
        byte[] channel = message.getChannel();
        log.info(new String(body));
        log.info(new String(channel));

        String str = new String(pattern);
        log.info("pattern是啥：{}", str);
    }
}
