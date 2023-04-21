package top.kangyong.sbsj.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.springframework.stereotype.Repository;
import top.kangyong.sbsj.domain.entity.DictOrderType;

/**
 * DictOrderType Dao
 *
 * @author Kang Yong
 * @date 2023/4/21
 * @since 1.0.0
 */
@Repository
public interface DictOrderTypeMapper {

    /**
     * 功能: 新增配置
     *
     * @param dictOrderType {@link DictOrderType}
     * @author Kang Yong
     * @date 2023/4/21
     */
    @Insert("INSERT INTO dict_order_type(id, order_type) VALUES(#{id}, #{orderType})")
    void insertDictOrderType(DictOrderType dictOrderType);

    /**
     * 功能: 根据id删除配置
     *
     * @param id {@link Integer}
     * @author Kang Yong
     * @date 2023/4/21
     */
    @Delete("DELETE FROM dict_order_type WHERE id=#{id}")
    void deleteDictOrderType(Integer id);

}
