package top.kangyong.study.mthread.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import top.kangyong.study.mthread.domain.User;
import top.kangyong.study.mthread.service.UserService;
import top.kangyong.study.mthread.mapper.UserMapper;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.*;

/**
* @author KY
* @description 针对表【user】的数据库操作Service实现
* @createDate 2023-03-31 17:53:34
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>  implements UserService{

    @Override
    public void addUser(User user) {
        this.save(user);
    }

    @Override
    public void checkBirthdayAndSendCongratulation() {
        /* 场景：(多线程案例)
         库里有n条数据，先查出数量，
         这里用线程池启动10个线程，计算每个线程需要处理的数据量，
         写一个算法，计算起止位置（LIMIT 100, 10）
         每个线程取到数据后，执行自己的业务
         */
        ExecutorService executorService = new ExecutorService() {
            @Override
            public void shutdown() {

            }

            @Override
            public List<Runnable> shutdownNow() {
                return null;
            }

            @Override
            public boolean isShutdown() {
                return false;
            }

            @Override
            public boolean isTerminated() {
                return false;
            }

            @Override
            public boolean awaitTermination(long timeout, TimeUnit unit) throws InterruptedException {
                return false;
            }

            @Override
            public <T> Future<T> submit(Callable<T> task) {
                return null;
            }

            @Override
            public <T> Future<T> submit(Runnable task, T result) {
                return null;
            }

            @Override
            public Future<?> submit(Runnable task) {
                return null;
            }

            @Override
            public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks) throws InterruptedException {
                return null;
            }

            @Override
            public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks, long timeout, TimeUnit unit) throws InterruptedException {
                return null;
            }

            @Override
            public <T> T invokeAny(Collection<? extends Callable<T>> tasks) throws InterruptedException, ExecutionException {
                return null;
            }

            @Override
            public <T> T invokeAny(Collection<? extends Callable<T>> tasks, long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
                return null;
            }

            @Override
            public void execute(Runnable command) {

            }
        };


    }

}




