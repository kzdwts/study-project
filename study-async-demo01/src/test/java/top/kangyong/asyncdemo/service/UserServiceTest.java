package top.kangyong.asyncdemo.service;

import java.util.concurrent.CompletableFuture;

/**
 * test
 *
 * @author Kang Yong
 * @date 2024/7/10
 * @since 1.0.0
 */

public class UserServiceTest {

    public void showAsync() {
        CompletableFuture.runAsync(() -> {
            try {
                // 业务代码
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                System.out.println("异步任务结束");
            }
        });
    }

}