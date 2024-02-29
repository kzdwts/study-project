package top.kangyong.study.easyes.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.dromara.easyes.annotation.IndexField;
import org.dromara.easyes.annotation.IndexId;
import org.dromara.easyes.annotation.IndexName;
import org.dromara.easyes.annotation.rely.FieldType;
import org.dromara.easyes.annotation.rely.IdType;

import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * 文章
 *
 * @author Kang Yong
 * @date 2024/2/1
 * @since 1.0.0
 */
@Data
@EqualsAndHashCode
@IndexName(value = "article")
//@Setting
public class Article {

    @IndexId(type = IdType.NONE)
    private String id;

    /**
     * 自定义id
     */
    @IndexField(fieldType = FieldType.KEYWORD)
    private Long cusId;

    /**
     * 标题
     */
    @IndexField(fieldType = FieldType.KEYWORD)
    private String title;
    /**
     * 内容
     * <p>
     * ik_max_word
     * 将文档里的字词进行拆分，其拆分粒度细。比如：我是程序员 ----> 我  是  程序员  程序  员
     * 　　　　　　　　　　　　　　　　　　　　　　今天星期一 ----> 今天  星期一
     */

    @IndexField(fieldType = FieldType.TEXT, analyzer = "ik_max_word")
    private String content;

    /**
     * 描述
     * <p>
     * ik_smart
     * 将文档里的字词进行拆分，其拆分粒度粗。比如：我是程序员 ----> 我  是  程序员
     * 　　　　　　　　　　　　　　　　　　　　　　今天星期一 ---->今天  星期一  星期  一
     */
    @IndexField(fieldType = FieldType.TEXT, analyzer = "ik_smart")
    private String desc;

    /**
     * 作者
     */
    @IndexField(fieldType = FieldType.KEYWORD)
    private String author;

    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    /**
     * 项目ID
     */
    @IndexField(fieldType = FieldType.KEYWORD)
    private String projectId;

    /**
     * 分期ID，多个逗号分隔
     */
    @IndexField(fieldType = FieldType.TEXT, analyzer = "comma", searchAnalyzer = "comma")
    private String stageId;

    /**
     * 不加注解默认是keyword
     */
    private String stageIdStr;

    private Set<String> stageIdList;
}
