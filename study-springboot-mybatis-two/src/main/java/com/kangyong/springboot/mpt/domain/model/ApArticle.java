package com.kangyong.springboot.mpt.domain.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 文章信息表，存储已发布的文章
 *
 * @TableName ap_article
 */
@TableName(value = "ap_article")
@Data
public class ApArticle implements Serializable {
    /**
     *
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 标题
     */
    private String title;

    /**
     * 文章作者的ID
     */
    private Integer authorId;

    /**
     * 作者昵称
     */
    private String authorName;

    /**
     * 文章所属频道ID
     */
    private Integer channelId;

    /**
     * 频道名称
     */
    private String channelName;

    /**
     * 文章布局
     * 0 无图文章
     * 1 单图文章
     * 2 多图文章
     */
    private Integer layout;

    /**
     * 文章标记
     * 0 普通文章
     * 1 热点文章
     * 2 置顶文章
     * 3 精品文章
     * 4 大V 文章
     */
    private Integer flag;

    /**
     * 文章图片
     * 多张逗号分隔
     */
    private String images;

    /**
     * 文章标签最多3个 逗号分隔
     */
    private String labels;

    /**
     * 点赞数量
     */
    private Integer likes;

    /**
     * 收藏数量
     */
    private Integer collection;

    /**
     * 评论数量
     */
    private Integer comment;

    /**
     * 阅读数量
     */
    private Integer views;

    /**
     * 省市
     */
    private Integer provinceId;

    /**
     * 市区
     */
    private Integer cityId;

    /**
     * 区县
     */
    private Integer countyId;

    /**
     * 创建时间
     */
    private Date createdTime;

    /**
     * 发布时间
     */
    private Date publishTime;

    /**
     * 同步状态
     */
    private Integer syncStatus;

    /**
     * 来源
     */
    private Integer origin;

    /**
     *
     */
    private String staticUrl;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}