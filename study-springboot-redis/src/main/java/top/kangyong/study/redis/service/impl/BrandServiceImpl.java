package top.kangyong.study.redis.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.cache.annotation.Cacheable;
import top.kangyong.study.redis.domain.Brand;
import top.kangyong.study.redis.service.BrandService;
import top.kangyong.study.redis.mapper.BrandMapper;
import org.springframework.stereotype.Service;

/**
 * @author KY
 * @description 针对表【brand(品牌表)】的数据库操作Service实现
 * @createDate 2022-09-25 22:52:06
 */
@Service
public class BrandServiceImpl extends ServiceImpl<BrandMapper, Brand> implements BrandService {

    @Override
    public Brand getByBrandId(Integer brandId) {
        return this.getById(brandId);
    }

    @Cacheable(cacheNames = "brand", key = "'{'+#id+'}'")
    @Override
    public String getNameById(Integer id) {
        return this.getById(id).getName();
    }
}




