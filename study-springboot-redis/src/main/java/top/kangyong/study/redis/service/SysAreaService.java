package top.kangyong.study.redis.service;

import top.kangyong.study.redis.domain.model.SysArea;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 *
 */
public interface SysAreaService extends IService<SysArea> {

    /**
     * 根据code获取区域信息
     *
     * @param code {@link Integer}
     * @return {@link SysArea}
     * @author Kang Yong
     * @date 2022/9/29
     */
    SysArea getAreaByCode(Integer code);

}
