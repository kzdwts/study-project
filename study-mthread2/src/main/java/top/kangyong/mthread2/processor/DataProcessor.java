package top.kangyong.mthread2.processor;

import com.alibaba.fastjson.JSON;
import top.kangyong.mthread2.util.ListUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * test
 *
 * @author Kang Yong
 * @date 2023/11/14
 * @since 1.0.0
 */
public class DataProcessor {

    private static final int BATCH_SIZE = 100;
    private static final ExecutorService executorService = Executors.newFixedThreadPool(10); // 创建固定大小的线程池

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        List<String> dataList = generateData(17000000); // 假设有17000000条数据需要处理
        List<List<String>> tempDataList = ListUtils.splitList(dataList, 1000);
        // 开始投递
        int i = 0;
        for (List<String> list : tempDataList) {
            i++;
            System.out.println("===START处理第i = " + i + "批数据");
            dealGroupData(list);
            System.out.println("===END处理第i = " + i + "批数据");
        }

    }

    private static void dealGroupData(List<String> list) throws ExecutionException, InterruptedException {
        System.out.println("===正在处理数据数据," + JSON.toJSONString(list));

        List<CompletableFuture<Void>> futures = new ArrayList<>();
        for (String s : list) {
            CompletableFuture<Void> future = CompletableFuture.runAsync(() -> processSingle(s), executorService);
            futures.add(future);
        }
        // 等待所有异步任务完成
        CompletableFuture<Void> allOf = CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));
        allOf.join();

        System.out.println("===已结束处理数据数据," + JSON.toJSONString(list));
    }

    // 处理数据的函数，这里只是一个示例，你可以根据实际需求进行修改
    private static void processSingle(String item) {
        // 对数据进行处理，例如：将数据写入数据库、进行计算等操作...
        System.out.println("处理数据: " + item);
    }

    private static void processBatch(List<String> batch) {
        // 对数据进行处理，例如：将数据写入数据库、进行计算等操作...
        for (String item : batch) {
            System.out.println("处理数据: " + item);
        }
    }

    // 生成模拟数据的函数，这里只是一个示例，你可以根据实际需求进行修改
    private static List<String> generateData(int count) {
        List<String> data = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            data.add("data" + i); // 这里只是简单地用 "data" + i 来模拟数据，你可以根据实际需求生成复杂的数据...
        }
        return data;
    }

}
