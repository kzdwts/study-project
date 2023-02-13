package top.kangyong.study.tp.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName user1
 */
@TableName(value ="user1")
@Data
public class User1 implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Object id;

    /**
     * 
     */
    private String name;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}