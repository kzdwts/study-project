package top.kangyong.study.redis.service;

import java.util.List;

/**
 * interface
 *
 * @author Kang Yong
 * @date 2022/11/29
 * @since 1.0.0
 */
public interface ClueService {

    /**
     * 初始化list到缓存
     *
     * @param ids {@link List< Integer>}
     * @author Kang Yong
     * @date 2022/11/29
     */
    void initDataList(List<Integer> ids);

    /**
     * 从缓存获取list数据
     * <p>
     * 类似于：lrange key 0 -1
     *
     * @return {@link List< Integer>}
     * @author Kang Yong
     * @date 2022/11/29
     */
    List<Integer> getDataList();

    /**
     * 获取最新的数据
     * <p>
     * 类似于：lpop key
     *
     * @return {@link Integer}
     * @author Kang Yong
     * @date 2022/11/29
     */
    Integer getOne();

    /**
     * 新增数据
     * <p>
     * 类似于：rpush key val1
     *
     * @param id {@link Integer}
     * @author Kang Yong
     * @date 2022/11/29
     */
    void add(Integer id);
}
