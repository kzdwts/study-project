package top.kangyong.mthread2.util;

import java.util.ArrayList;
import java.util.List;

/**
 * List拆分
 *
 * @author Kang Yong
 * @date 2023/10/31
 * @since 1.0.0
 */
public class ListUtils {

    /**
     * 将一个 List 拆分成多个子列表，每个子列表的大小为 batchSize
     *
     * @param list {@link T}
     * @return {@link T}
     * @author Kang Yong
     * @date 2023/10/31
     */
    public static <T> List<List<T>> splitList(List<T> list, int batchSize) {
        List<List<T>> subLists = new ArrayList<>();

        for (int i = 0; i < list.size(); i += batchSize) {
            int end = Math.min(i + batchSize, list.size());
            subLists.add(list.subList(i, end));
        }

        return subLists;
    }

}
