package top.kangyong.study.aevent.domain.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * 
 * @TableName user_detail
 */
@TableName(value ="user_detail")
@Data
public class UserDetail implements Serializable {
    /**
     * 
     */
    @TableId
    private Integer userId;

    /**
     * 性别
     */
    private Integer gender;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 家乡
     */
    private String home;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}