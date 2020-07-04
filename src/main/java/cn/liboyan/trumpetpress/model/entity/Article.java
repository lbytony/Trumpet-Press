package cn.liboyan.trumpetpress.model.entity;

import lombok.Data;

import java.util.Date;
import java.io.Serializable;
import java.util.List;

/**
 * (Article)实体类
 *
 * @author Li Boyan
 * @since 2020-05-03 13:39:37
 */
@Data
public class Article implements Serializable {
    private static final long serialVersionUID = -63402543301614282L;

    private Long articleId;
    /**
     * 博客标题
     */
    private String articleTitle;
    /**
     * 博客内容
     */
    private String articleContent;
    /**
     * 博客浏览量
     */
    private Integer articleViews;
    /**
     * 博客点赞量
     */
    private Integer articleLikes;
    /**
     * 博客状态 1发布 0草稿
     */
    private Boolean articleStatus;
    /**
     * 博客评论数
     */
    private Integer articleComments;
    /**
    * 创建时间
    */
    private Date articleCreateTime;
    /**
    * 更新时间
     */
    private Date articleUpdateTime;
    /**
     * 创建人ID
     */
    private Long userId;
    /**
     * 类型ID
     */
    private Long typeId;

    private List<Tag> articleTags;

    private Type articleType;

    private Boolean isRecommend;

    private Boolean isOriginal;

    private User user;

    private String tagIds;

    private Boolean allowComment;

    private Boolean allowAppreciate;

    public void init() {
        this.tagIds = tagsToIds(this.articleTags);
    }

    private String tagsToIds(List<Tag> tags) {
        if (!tags.isEmpty()) {
            StringBuilder ids = new StringBuilder();
            boolean flag = false;
            for (Tag tag : tags) {
                if (flag) {
                    ids.append(",");
                } else {
                    flag = true;
                }
                ids.append(tag.getTagId());
            }
            return ids.toString();
        } else {
            return tagIds;
        }
    }

}