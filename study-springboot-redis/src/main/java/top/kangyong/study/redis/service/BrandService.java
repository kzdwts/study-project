package top.kangyong.study.redis.service;

import top.kangyong.study.redis.domain.Brand;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @author KY
 * @description 针对表【brand(品牌表)】的数据库操作Service
 * @createDate 2022-09-25 22:52:06
 */
public interface BrandService extends IService<Brand> {

    /**
     * 根据id获取
     *
     * @param brandId {@link Integer}
     * @return {@link Brand}
     * @author Kang Yong
     * @date 2022/9/25
     */
    Brand getByBrandId(Integer brandId);

    /**
     * 根据id查询名称
     *
     * @param id {@link Integer}
     * @return {@link String}
     * @author Kang Yong
     * @date 2022/9/25
     */
    String getNameById(Integer id);
}
