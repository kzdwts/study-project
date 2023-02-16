package top.kangyong.study.tp.service.user;

import com.baomidou.mybatisplus.extension.service.IService;
import top.kangyong.study.tp.domain.User2;

/**
 * @author KY
 * @description 针对表【user2】的数据库操作Service
 * @createDate 2023-02-13 21:02:54
 */
public interface User2Service extends IService<User2> {

    /**
     * 功能: 新增
     *
     * @param user2 {@link User2}
     * @author Kang Yong
     * @date 2023/2/13
     */
    void addRequired(User2 user2);

    /**
     * 功能: 新增并抛出异常
     *
     * @param user2 {@link User2}
     * @author Kang Yong
     * @date 2023/2/13
     */
    void addRequiredException(User2 user2);

    /**
     * 功能: 新增（测试Propagation.REQUIRES_NEW）
     *
     * @param user2 {@link User2}
     * @author Kang Yong
     * @date 2023/2/15
     */
    void addRequiresNew(User2 user2);


    /**
     * 功能: 新增（测试Propagation.REQUIRES_NEW）
     *
     * @param user2 {@link User2}
     * @author Kang Yong
     * @date 2023/2/15
     */
    void addRequiresNewException(User2 user2);

    /**
     * 功能: 新增（测试Propagation.NESTED）
     *
     * @param user2 {@link User2}
     * @author Kang Yong
     * @date 2023/2/16
     */
    void addNested(User2 user2);

    /**
     * 功能: 新增（测试Propagation.NESTED exception）
     *
     * @param user2 {@link User2}
     * @author Kang Yong
     * @date 2023/2/16
     */
    void addNestedException(User2 user2);

}
