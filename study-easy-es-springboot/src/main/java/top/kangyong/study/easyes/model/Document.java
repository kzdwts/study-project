package top.kangyong.study.easyes.model;

import lombok.Data;
import org.dromara.easyes.annotation.IndexField;
import org.dromara.easyes.annotation.IndexId;
import org.dromara.easyes.annotation.IndexName;
import org.dromara.easyes.annotation.rely.FieldType;
import org.dromara.easyes.annotation.rely.IdType;

/**
 * ES数据模型
 * <p>
 * Copyright © 2021 xpc1024 All Rights Reserved
 **/
@Data
@IndexName("document")
public class Document {
    /**
     * es中的唯一id
     */
    @IndexId(type = IdType.CUSTOMIZE)
    private String id;

    /**
     * 文档标题
     */
    @IndexField(fieldType = FieldType.TEXT, analyzer = "ik_max_word")
    private String title;
    /**
     * 文档内容
     */
    private String content;
}
