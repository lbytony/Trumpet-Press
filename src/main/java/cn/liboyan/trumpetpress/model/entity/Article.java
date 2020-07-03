package cn.liboyan.trumpetpress.model.entity;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.Date;
import java.io.Serializable;
import java.util.List;

/**
 * (Article)实体类
 *
 * @author Li Boyan
 * @since 2020-05-03 13:39:37
 */
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

    public Boolean getIsRecommend() {
        return isRecommend;
    }

    public void setIsRecommend(Boolean recommend) {
        isRecommend = recommend;
    }

    public Boolean getIsOriginal() {
        return isOriginal;
    }

    public void setIsOriginal(Boolean original) {
        isOriginal = original;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Tag> getArticleTags() {
        return articleTags;
    }

    public void setArticleTags(List<Tag> articleTags) {
        this.articleTags = articleTags;
    }

    public Type getArticleType() {
        return articleType;
    }

    public void setArticleType(Type articleType) {
        this.articleType = articleType;
    }

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

    public String getArticleContent() {
        return articleContent;
    }

    public void setArticleContent(String articleContent) {
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

    public Boolean getArticleStatus() {
        return articleStatus;
    }

    public void setArticleStatus(Boolean articleStatus) {
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

    public String getTagIds() {
        return tagIds;
    }

    public void setTagIds(String tagIds) {
        this.tagIds = tagIds;
    }

    public Boolean getAllowComment() {
        return allowComment;
    }

    public void setAllowComment(Boolean allowComment) {
        this.allowComment = allowComment;
    }

    public Boolean getAllowAppreciate() {
        return allowAppreciate;
    }

    public void setAllowAppreciate(Boolean allowAppreciate) {
        this.allowAppreciate = allowAppreciate;
    }


    @Override
    public String toString() {
        return "Article{" +
                "articleId=" + articleId +
                ", articleTitle='" + articleTitle + '\'' +
                ", articleContent='" + articleContent + '\'' +
                ", articleViews=" + articleViews +
                ", articleLikes=" + articleLikes +
                ", articleStatus=" + articleStatus +
                ", articleComments=" + articleComments +
                ", articleCreateTime=" + articleCreateTime +
                ", articleUpdateTime=" + articleUpdateTime +
                ", userId=" + userId +
                ", typeId=" + typeId +
                ", articleTags=" + articleTags +
                ", articleType=" + articleType +
                ", isRecommend=" + isRecommend +
                ", isOriginal=" + isOriginal +
                ", user=" + user +
                ", tagIds='" + tagIds + '\'' +
                ", allowComment=" + allowComment +
                ", allowAppriciate=" + allowAppreciate +
                '}';
    }
}