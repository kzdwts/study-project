package top.kangyong.study.tp.service.user;

import top.kangyong.study.tp.domain.User1;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @author KY
 * @description 针对表【user1】的数据库操作Service
 * @createDate 2023-02-13 21:02:54
 */
public interface User1Service extends IService<User1> {

    /**
     * 功能: 新增
     *
     * @param user1 {@link User1}
     * @author Kang Yong
     * @date 2023/2/13
     */
    void addRequired(User1 user1);

    /**
     * 功能: 新增 （测试Propagation.REQUIRES_NEW）
     *
     * @param user1 {@link User1}
     * @author Kang Yong
     * @date 2023/2/15
     */
    void addRequiresNew(User1 user1);

}
