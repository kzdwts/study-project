package top.kangyong.study.redis.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import top.kangyong.study.redis.domain.constant.RedisKeyConstant;
import top.kangyong.study.redis.service.ClueService;

import java.util.Collection;
import java.util.List;

/**
 * service
 *
 * @author Kang Yong
 * @date 2022/11/29
 * @since 1.0.0
 */
@Service
public class ClueServiceImpl implements ClueService {

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public void initDataList(List<Integer> ids) {
        // 清空
        redisTemplate.delete(RedisKeyConstant.CLUE_KEY);

        // 保存
        ListOperations<String, Integer> ops = redisTemplate.opsForList();
        ops.rightPushAll(RedisKeyConstant.CLUE_KEY, ids);
    }

    @Override
    public List<Integer> getDataList() {
        ListOperations<String, Integer> ops = redisTemplate.opsForList();
        List<Integer> dataList = ops.range(RedisKeyConstant.CLUE_KEY, 0, -1);
        return dataList;
    }

    @Override
    public Integer getOne() {
        ListOperations<String, Integer> ops = redisTemplate.opsForList();
        Integer id = ops.leftPop(RedisKeyConstant.CLUE_KEY);
        return id;
    }

    @Override
    public void add(Integer id) {
        ListOperations<String, Integer> ops = redisTemplate.opsForList();
        ops.rightPush(RedisKeyConstant.CLUE_KEY, id);
    }
}
