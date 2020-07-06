package cn.liboyan.trumpetpress.model.vo;

import cn.liboyan.trumpetpress.model.entity.Tag;
import cn.liboyan.trumpetpress.model.entity.Type;
import cn.liboyan.trumpetpress.model.entity.User;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * ShowArticle
 *
 * @author Li Boyan
 * @version 1.0
 * @date 2020/7/4
 */
@Data
public class ShowIndexArticle {

    private Long articleId;
    /**
     * 博客标题
     */
    private String articleTitle;
    /**
     * 博客描述
     */
    private String articleDescription;
    /**
     * 博客浏览量
     */
    private Integer articleViews;
    /**
     * 更新时间
     */
    private Date articleUpdateTime;
    /**
     * 类型ID
     */
    private Long typeId;

    private Type articleType;

    private List<Tag> articleTags;

    private String articleTagsName;
}
