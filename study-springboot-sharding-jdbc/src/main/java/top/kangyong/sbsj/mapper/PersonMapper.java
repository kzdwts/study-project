package top.kangyong.sbsj.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import top.kangyong.sbsj.domain.entity.Customer;
import top.kangyong.sbsj.domain.entity.Person;

/**
 * Person Dao
 *
 * @author Kang Yong
 * @date 2023/4/21
 * @since 1.0.0
 */
@Repository
public interface PersonMapper {

    /**
     * 功能:新增person
     *
     * @param person {@link Person}
     * @author Kang Yong
     * @date 2023/4/21
     */
    @Insert("INSERT INTO person(id, name) VALUES(#{id}, #{name})")
    void insertPerson(Person person);

    /**
     * 功能: 根据id查询
     *
     * @param id {@link Long}
     * @return {@link Person}
     * @author Kang Yong
     * @date 2023/4/21
     */
    @Select("SELECT * FROM person WHERE id=#{id}")
    Person queryPerson(Long id);

}
