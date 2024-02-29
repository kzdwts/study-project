package top.kangyong.study.easyes.request;

import lombok.Data;

/**
 * 查询参数
 *
 * @author Kang Yong
 * @date 2024/2/2
 * @since 1.0.0
 */
@Data
public class ArticleSelectParam {


    private Long id;

    /**
     * 标题
     */
    private String title;
    /**
     * 内容
     */
    private String content;

    /**
     * 描述
     */
    private String desc;

    /**
     * 作者
     */
    private String author;

    /**
     * 项目ID
     */
    private String projectId;

    /**
     * 分期ID
     */
    private String stageId;

    private Integer pageNum = 1;
    private Integer pageSize = 20;
}
