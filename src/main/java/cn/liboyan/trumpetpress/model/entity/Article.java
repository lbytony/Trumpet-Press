package cn.liboyan.trumpetpress.model.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (Article)实体类
 *
 * @author Li Boyan
 * @since 2020-05-03 13:39:37
 */
public class Article implements Serializable {
    private static final long serialVersionUID = -63402543301614282L;
    /**
    * 博客ID
    */
    private Long articleId;
    /**
    * 博客标题
    */
    private String articleTitle;
    /**
    * 博客内容
    */
    private Object articleContent;
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
    private Object articleStatus;
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


    public Long getArticleId() {
        return articleId;
    }

    public void setArticleId(Long articleId) {
        this.articleId = articleId;
    }

    public String getArticleTitle() {
        return articleTitle;
    }

    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle;
    }

    public Object getArticleContent() {
        return articleContent;
    }

    public void setArticleContent(Object articleContent) {
        this.articleContent = articleContent;
    }

    public Integer getArticleViews() {
        return articleViews;
    }

    public void setArticleViews(Integer articleViews) {
        this.articleViews = articleViews;
    }

    public Integer getArticleLikes() {
        return articleLikes;
    }

    public void setArticleLikes(Integer articleLikes) {
        this.articleLikes = articleLikes;
    }

    public Object getArticleStatus() {
        return articleStatus;
    }

    public void setArticleStatus(Object articleStatus) {
        this.articleStatus = articleStatus;
    }

    public Integer getArticleComments() {
        return articleComments;
    }

    public void setArticleComments(Integer articleComments) {
        this.articleComments = articleComments;
    }

    public Date getArticleCreateTime() {
        return articleCreateTime;
    }

    public void setArticleCreateTime(Date articleCreateTime) {
        this.articleCreateTime = articleCreateTime;
    }

    public Date getArticleUpdateTime() {
        return articleUpdateTime;
    }

    public void setArticleUpdateTime(Date articleUpdateTime) {
        this.articleUpdateTime = articleUpdateTime;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

}