package top.kangyong.study.redis.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.stereotype.Component;

/**
 * 监听redis 消息(ChatGPT提供的demo，目前没测试到这个啥作用)
 *
 * @author Kang Yong
 * @date 2023/3/15
 * @since 1.0.0
 */
@Slf4j
@Component
public class RedisMessageListener implements MessageListener {

    @Override
    public void onMessage(Message message, byte[] bytes) {
        log.info("RedisMessageListener[onMessage]");

        System.out.println("Received Message:" + message);
        String topic = new String(message.getChannel());
        String content = new String(message.getBody());
        System.out.println("接收到消息，主题：" + topic + "，内容：" + content);

        String msg = new String(bytes);
        System.out.println("msg = " + msg);
    }

}
