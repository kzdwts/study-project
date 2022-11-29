package top.kangyong.study.redis.domain.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @TableName sys_area
 */
@TableName(value = "sys_area")
@Data
public class SysArea implements Serializable {
    /**
     * id
     */
    private Integer id;

    /**
     * 名称
     */
    private String areaName;

    /**
     * 全称，格式：["省","市","区"]
     */
    private String areaFullName;

    /**
     * 编码
     */
    private Integer areaCode;

    /**
     * 父级编码
     */
    private Integer areaParentCode;

    /**
     * 类型
     */
    private Integer areaTypeCode;

    /**
     * 创建时间
     */
    private Date createTime;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}
