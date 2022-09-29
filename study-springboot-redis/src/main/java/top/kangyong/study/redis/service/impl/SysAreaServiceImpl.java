package top.kangyong.study.redis.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.cache.annotation.Cacheable;
import top.kangyong.study.redis.domain.SysArea;
import top.kangyong.study.redis.service.SysAreaService;
import top.kangyong.study.redis.mapper.SysAreaMapper;
import org.springframework.stereotype.Service;

/**
 *
 */
@Service
public class SysAreaServiceImpl extends ServiceImpl<SysAreaMapper, SysArea> implements SysAreaService {

    /**
     * 根据code获取区域信息
     *
     * @param code {@link Integer}
     * @return {@link SysArea}
     * @author Kang Yong
     * @date 2022/9/29
     */
    @Cacheable(cacheNames = "local::area::data", key = "#code", unless = "#result == null")
    @Override
    public SysArea getAreaByCode(Integer code) {
        return this.getOne(Wrappers.<SysArea>lambdaQuery()
                .eq(SysArea::getAreaCode, code)
        );
    }
}




