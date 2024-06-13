package com.kangyong.springboot.mpt.domain.param;

import lombok.Data;

import java.io.Serializable;

/**
 * 查询参数
 *
 * @author Kang Yong
 * @date 2024/6/13
 * @since 1.0.0
 */
@Data
public class ArticleParam implements Serializable {

    private Long id;
    private String title;
    private String authorName;
    private String channelName;
    private Integer flag;
    private String content;

}
