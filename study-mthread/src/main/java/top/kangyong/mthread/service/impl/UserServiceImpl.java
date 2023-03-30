package top.kangyong.mthread.service.impl;

import org.springframework.stereotype.Service;
import top.kangyong.mthread.service.UserService;

/**
 * 业务处理
 *
 * @author Kang Yong
 * @date 2023/3/30
 * @since 1.0.0
 */
@Service
public class UserServiceImpl implements UserService {


    @Override
    public void checkBirthdayAndSendCongratulation() {
        /* 场景：(多线程案例)
         库里有n条数据，先查出数量，
         这里用线程池启动10个线程，计算每个线程需要处理的数据量，
         写一个算法，计算起止位置（LIMIT 100, 10）
         每个线程取到数据后，执行自己的业务
         */


    }
}
