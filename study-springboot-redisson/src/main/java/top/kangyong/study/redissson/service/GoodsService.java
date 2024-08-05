package top.kangyong.study.redissson.service;

import lombok.extern.slf4j.Slf4j;
import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import top.kangyong.study.redissson.domain.dto.goods.request.SkillGoodsInitParam;
import top.kangyong.study.redissson.domain.dto.goods.request.SkillGoodsParam;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

/**
 * 商品
 *
 * @author Kang Yong
 * @date 2024/8/2
 * @since 1.0.0
 */
@Slf4j
@Service
public class GoodsService {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Autowired
    private Redisson redisson;

    @Autowired
    private RedissonClient redissonClient;

    public static final String GOODS_KEY = "GOODS_KEY:%s";
    public static final String GOODS_LOCK = "GOODS_LOCK:%s";

    public boolean initGoods(SkillGoodsInitParam param) {
        log.info("GoodsService[initGoods]===START");
        String key = String.format(GOODS_KEY, param.getGoodsId());
        redisTemplate.opsForValue().set(key, String.valueOf(param.getGoodsCount()));
        System.out.println("初始化库存成功");
        log.info("GoodsService[initGoods]===END");

        return true;
    }

    public boolean skillGoods1(SkillGoodsParam param) {
        log.info("GoodsService[skillGoods1]===START");
        synchronized (this) {
            String key = String.format(GOODS_KEY, param.getGoodsId());
            String goodsCount = redisTemplate.opsForValue().get(key);
            Integer count = Integer.valueOf(goodsCount);
            if (count > 0) {
                redisTemplate.opsForValue().set(key, String.valueOf(count - 1));
                System.out.println("GoodsService[skillGoods1]===" + param.getUserName() + "抢到了" + param.getGoodsId() + "商品");
                return true;
            }
        }

        return false;
    }


    public boolean skillGoods2(SkillGoodsParam param) {
        log.info("GoodsService[skillGoods2]===START");

        String lockKey = String.format(GOODS_LOCK, param.getGoodsId());
        Boolean goodsLock = redisTemplate.opsForValue().setIfAbsent(lockKey, "lock");
        if (!goodsLock) {
            System.out.println("没有获取到锁");
            return false;
        }

        try {
            String key = String.format(GOODS_KEY, param.getGoodsId());
            String goodsCount = redisTemplate.opsForValue().get(key);
            Integer count = Integer.valueOf(goodsCount);
            if (count > 0) {
                redisTemplate.opsForValue().set(key, String.valueOf(count - 1));
                System.out.println("GoodsService[skillGoods2]===" + param.getUserName() + "抢到了" + param.getGoodsId() + "商品");
                return true;
            }
        } finally {
            // 如果刚好在这里 异常或者服务器宕机，导致无法释放锁

            // 释放锁
            redisTemplate.delete(lockKey);
        }

        log.info("GoodsService[skillGoods2]===END");
        return false;
    }

    public boolean skillGoods3(SkillGoodsParam param) {
        log.info("GoodsService[skillGoods3]===START");

        int i = 0;
        String lockKey = String.format(GOODS_LOCK, param.getGoodsId());
        Boolean goodsLock = redisTemplate.opsForValue().setIfAbsent(lockKey, "lock");
        if (!goodsLock) {
            System.out.println("没有获取到锁");
            return false;
        }

        try {
            String key = String.format(GOODS_KEY, param.getGoodsId());
            String goodsCount = redisTemplate.opsForValue().get(key);
            Integer count = Integer.valueOf(goodsCount);
            if (count > 0) {
                i = count;
                redisTemplate.opsForValue().set(key, String.valueOf(count - 1));
                System.out.println("GoodsService[skillGoods3]===" + param.getUserName() + "抢到了" + param.getGoodsId() + "商品");
                System.out.println("GoodsService[skillGoods3]===剩余库存：" + (count - 1));
                return true;
            }
        } finally {
            // 模拟异常
            if (i == 10) {
                System.out.println("模拟异常===出现异常");
                System.exit(0);
            }

            // 释放锁
            redisTemplate.delete(lockKey);
        }

        log.info("GoodsService[skillGoods3]===END");
        return false;
    }

    public boolean skillGoods4(SkillGoodsParam param) {
        log.info("GoodsService[skillGoods4]===START");

        String lockKey = String.format(GOODS_LOCK, param.getGoodsId());
        // 获取锁3秒
        Boolean goodsLock = redisTemplate.opsForValue().setIfAbsent(lockKey, "lock", 3, TimeUnit.SECONDS);
        if (!goodsLock) {
            System.out.println("没有获取到锁");
            return false;
        }

        try {
            String key = String.format(GOODS_KEY, param.getGoodsId());
            String goodsCount = redisTemplate.opsForValue().get(key);
            Integer count = Integer.valueOf(goodsCount);
            if (count > 0) {
                try {
                    Thread.sleep(10000L);
                } catch (InterruptedException e) {

                }
                redisTemplate.opsForValue().set(key, String.valueOf(count - 1));
                System.out.println("GoodsService[skillGoods4]===" + param.getUserName() + "抢到了" + param.getGoodsId() + "商品");
                System.out.println("GoodsService[skillGoods4]===剩余库存：" + (count - 1));
                return true;
            }
        } finally {
            // 释放锁
            redisTemplate.delete(lockKey);
        }

        log.info("GoodsService[skillGoods4]===END");
        return false;
    }

    public boolean skillGoods5(SkillGoodsParam param) {
        log.info("GoodsService[skillGoods5]===START");

        String lockKey = String.format(GOODS_LOCK, param.getGoodsId());
        // 获取锁3秒
        Boolean goodsLock = redisTemplate.opsForValue().setIfAbsent(lockKey, "lock", 3, TimeUnit.SECONDS);
        if (!goodsLock) {
            System.out.println("没有获取到锁");
            return false;
        }

        Timer timer = null;
        try {
            String key = String.format(GOODS_KEY, param.getGoodsId());
            String goodsCount = redisTemplate.opsForValue().get(key);
            Integer count = Integer.valueOf(goodsCount);
            if (count > 0) {
                timer = new Timer();
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        redisTemplate.opsForValue().setIfAbsent(lockKey, "lock", 3, TimeUnit.SECONDS);
                    }
                }, 0, 1);

                redisTemplate.opsForValue().set(key, String.valueOf(count - 1));
                System.out.println("GoodsService[skillGoods5]===" + param.getUserName() + "抢到了" + param.getGoodsId() + "商品");
                System.out.println("GoodsService[skillGoods5]===剩余库存：" + (count - 1));
                return true;
            }
        } finally {
            if (timer != null) {
                timer.cancel();
            }
            // 释放锁
            redisTemplate.delete(lockKey);
        }

        log.info("GoodsService[skillGoods5]===END");
        return false;
    }

    public boolean skillGoods6(SkillGoodsParam param) {
        log.info("GoodsService[skillGoods6]===START");

        String lockKey = String.format(GOODS_LOCK, param.getGoodsId());
        RLock lock = redisson.getLock(lockKey);
        log.info("GoodsService[skillGoods6]lockName:{}, isLocked:{}", lock.getName(), lock.isLocked());
        lock.lock(3, TimeUnit.SECONDS);

        try {
            String key = String.format(GOODS_KEY, param.getGoodsId());
            String goodsCount = redisTemplate.opsForValue().get(key);
            Integer count = Integer.valueOf(goodsCount);
            if (count > 0) {
                redisTemplate.opsForValue().set(key, String.valueOf(count - 1));
                System.out.println("GoodsService[skillGoods6]===" + param.getUserName() + "抢到了" + param.getGoodsId() + "商品");
                System.out.println("GoodsService[skillGoods6]===剩余库存：" + (count - 1));
                return true;
            }
        } finally {
            // 释放锁
            lock.unlock();
        }

        log.info("GoodsService[skillGoods6]===END");
        return false;
    }

    public boolean skillGoods7(SkillGoodsParam param) {
        log.info("GoodsService[skillGoods7]===START");

        String lockKey = String.format(GOODS_LOCK, param.getGoodsId());
        RLock lock = redisson.getLock(lockKey);
        log.info("GoodsService[skillGoods7]lockName:{}, isLocked:{}", lock.getName(), lock.isLocked());
        lock.lock(3, TimeUnit.SECONDS); // 实践证明lock()方法加参数和不加参数差别很大，猜测加参数没有使用看门狗自动续期，待进一步验证

        try {
            String key = String.format(GOODS_KEY, param.getGoodsId());
            String goodsCount = redisTemplate.opsForValue().get(key);
            Integer count = Integer.valueOf(goodsCount);
            if (count > 0) {
                try {
                    // TODO 这里睡3s，会导致finally解锁报错，待进一步验证
                    Thread.sleep(3000L);
                } catch (InterruptedException e) {

                }

                redisTemplate.opsForValue().set(key, String.valueOf(count - 1));
                System.out.println("GoodsService[skillGoods7]===" + param.getUserName() + "抢到了" + param.getGoodsId() + "商品");
                System.out.println("GoodsService[skillGoods7]===剩余库存：" + (count - 1));
                return true;
            }
        } finally {
            // 释放锁
            lock.unlock();
        }

        log.info("GoodsService[skillGoods7]===END");
        return false;
    }

    public boolean skillGoods8(SkillGoodsParam param) {
        log.info("GoodsService[skillGoods8]===START");

        String lockKey = String.format(GOODS_LOCK, param.getGoodsId());
        RLock lock = redisson.getLock(lockKey);
        log.info("GoodsService[skillGoods8]lockName:{}, isLocked:{}", lock.getName(), lock.isLocked());
        lock.lock();

        try {
            String key = String.format(GOODS_KEY, param.getGoodsId());
            String goodsCount = redisTemplate.opsForValue().get(key);
            Integer count = Integer.valueOf(goodsCount);
            if (count > 0) {
                try {
                    Thread.sleep(3000L);
                } catch (InterruptedException e) {

                }

                redisTemplate.opsForValue().set(key, String.valueOf(count - 1));
                System.out.println("GoodsService[skillGoods8]===" + param.getUserName() + "抢到了" + param.getGoodsId() + "商品");
                System.out.println("GoodsService[skillGoods8]===剩余库存：" + (count - 1));
                return true;
            }
        } finally {
            // 释放锁
            lock.unlock();
        }

        log.info("GoodsService[skillGoods8]===END");
        return false;
    }

    /**
     * 靠谱
     *
     * @param param {@link SkillGoodsParam}
     * @return {@link boolean}
     * @author Kang Yong
     * @date 2024/8/2
     */
    public boolean skillGoods9(SkillGoodsParam param) {
        log.info("GoodsService[skillGoods9]===START");

        String lockKey = String.format(GOODS_LOCK, param.getGoodsId());
        RLock lock = redisson.getLock(lockKey);
        log.info("GoodsService[skillGoods9]lockName:{}, isLocked:{}", lock.getName(), lock.isLocked());
        lock.lock(); // 目前验证不带参数的方法会启用看门狗模式

        int i = 0;
        try {
            String key = String.format(GOODS_KEY, param.getGoodsId());
            String goodsCount = redisTemplate.opsForValue().get(key);
            Integer count = Integer.valueOf(goodsCount);
            if (count > 0) {
                i = count;
                try {
                    Thread.sleep(3000L);
                } catch (InterruptedException e) {

                }

                redisTemplate.opsForValue().set(key, String.valueOf(count - 1));
                System.out.println("GoodsService[skillGoods9]===" + param.getUserName() + "抢到了" + param.getGoodsId() + "商品");
                System.out.println("GoodsService[skillGoods9]===剩余库存：" + (count - 1));
                return true;
            }
        } finally {
            if (i <= 10) {
                System.exit(0);
            }

            // 释放锁
            lock.unlock();
        }

        log.info("GoodsService[skillGoods9]===END");
        return false;
    }

    public boolean skillGoods10(SkillGoodsParam param) {
        log.info("GoodsService[skillGoods10]===START");

        String lockKey = String.format(GOODS_LOCK, param.getGoodsId());
        RLock lock = redissonClient.getLock(lockKey);
        log.info("GoodsService[skillGoods10]lockName:{}, isLocked:{}", lock.getName(), lock.isLocked());
        lock.lock(); // 目前验证不带参数的方法会启用看门狗模式

        int i = 0;
        try {
            String key = String.format(GOODS_KEY, param.getGoodsId());
            String goodsCount = redisTemplate.opsForValue().get(key);
            Integer count = Integer.valueOf(goodsCount);
            if (count > 0) {
                i = count;
                try {
                    Thread.sleep(3000L);
                } catch (InterruptedException e) {

                }

                redisTemplate.opsForValue().set(key, String.valueOf(count - 1));
                System.out.println("GoodsService[skillGoods10]===" + param.getUserName() + "抢到了" + param.getGoodsId() + "商品");
                System.out.println("GoodsService[skillGoods10]===剩余库存：" + (count - 1));
                return true;
            }
        } finally {
//            if (i <= 10) {
//                System.exit(0);
//            }

            // 释放锁
            lock.unlock();
        }

        log.info("GoodsService[skillGoods10]===END");
        return false;
    }
}
