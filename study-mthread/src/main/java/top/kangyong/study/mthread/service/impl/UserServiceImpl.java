package top.kangyong.study.mthread.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import top.kangyong.study.mthread.domain.User;
import top.kangyong.study.mthread.holder.BirthdayCongratulationHolder;
import top.kangyong.study.mthread.service.UserService;
import top.kangyong.study.mthread.mapper.UserMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author KY
 * @description 针对表【user】的数据库操作Service实现
 * @createDate 2023-03-31 17:53:34
 */
@Slf4j
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Override
    public void addUser(User user) {
        this.save(user);
    }

    @Override
    public void checkBirthdayAndSendCongratulation() {
        /* 场景：(多线程案例)
         库里有n条数据，先查出数量，
         这里用线程池启动10个线程，计算每个线程需要处理的数据量，
         写一个算法，计算起止位置（id BETWEEN 100 AND 10, 因为id是自增可以这么做）
         每个线程取到数据后，执行自己的业务
         */
        Integer processNum = Runtime.getRuntime().availableProcessors();
        ExecutorService pool = Executors.newFixedThreadPool(processNum);

        // 用户数量
        Integer userCount = this.getUserCount();
        if (userCount == 0) {
            log.info("暂无用户，退出");
            return;
        }

        for (int i = 0; i < processNum; i++) {
//            Integer pageSize = calcPageSize(processNum, userCount);
            Integer begin = calcBegin(i, processNum, userCount);
            Integer end = calcEnd(i, processNum, userCount);
            pool.submit(new BirthdayCongratulationHolder(begin, end));
        }

        System.out.println("开启线程数：processNum = " + processNum);
        System.out.println("all thread submit");
//        pool.shutdown();
    }

    /**
     * 功能: 计算分页结束位置
     *
     * @param pageNum    {@link int}
     * @param processNum {@link Integer}
     * @param userCount  {@link Integer}
     * @return {@link Integer}
     * @author Kang Yong
     * @date 2023/4/6
     */
    private Integer calcEnd(int pageNum, Integer processNum, Integer userCount) {
        return calcPageSize(processNum, userCount) * pageNum;
    }

    /**
     * 功能: 计算分页数量
     *
     * @param processNum {@link Integer}
     * @param userCount  {@link Integer}
     * @return {@link int}
     * @author Kang Yong
     * @date 2023/4/6
     */
    private int calcPageSize(Integer processNum, Integer userCount) {
        return (int) Math.ceil(userCount * 1.0 / processNum);
    }

    /**
     * 功能: 计算分页开始位置
     *
     * @param pageNum    {@link int}
     * @param processNum {@link Integer}
     * @param userCount  {@link Integer}
     * @return {@link Integer}
     * @author Kang Yong
     * @date 2023/4/6
     */
    private Integer calcBegin(int pageNum, Integer processNum, Integer userCount) {
        if (pageNum == 0) {
            // `MySQL LIMIT` 从0开始
            return 0;
        }

        // 计算分页开始位置
        return calcPageSize(processNum, userCount) * pageNum;
    }

    /**
     * 功能: 查询用户数量
     *
     * @return {@link Integer}
     * @author Kang Yong
     * @date 2023/4/6
     */
    private Integer getUserCount() {
        return this.count();
    }

}




