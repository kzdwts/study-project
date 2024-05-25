package com.kangyong.mpdm.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 
 * @TableName TB_STU
 */
@TableName(value ="TB_STU")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TbStu implements Serializable {
    /**
     * 
     */
    @TableId
    private Long id;

    /**
     * 
     */
    private String name;

    /**
     * 
     */
    private Integer age;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    public TbStu(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
}