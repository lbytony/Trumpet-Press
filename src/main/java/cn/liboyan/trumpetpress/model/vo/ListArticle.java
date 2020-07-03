package cn.liboyan.trumpetpress.model.vo;

import cn.liboyan.trumpetpress.model.entity.Type;

import java.io.Serializable;
import java.util.Date;

/**
 * ListArticle
 *
 * @author Li Boyan
 * @version 1.0
 * @date 2020/7/3
 */
public class ListArticle implements Serializable {

    private static final long serialVersionUID = -6354649274899717020L;

    private Long articleId;

    private String articleTitle;

    private Long typeId;

    private Type articleType;

    private Boolean isRecommend;

    private Integer articleViews;

    private Integer articleLikes;

    private Boolean articleStatus;

    private Date articleUpdateTime;

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

    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    public Type getArticleType() {
        return articleType;
    }

    public void setArticleType(Type articleType) {
        this.articleType = articleType;
    }

    public Boolean getRecommend() {
        return isRecommend;
    }

    public void setRecommend(Boolean recommend) {
        isRecommend = recommend;
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

    public Date getArticleUpdateTime() {
        return articleUpdateTime;
    }

    public void setArticleUpdateTime(Date articleUpdateTime) {
        this.articleUpdateTime = articleUpdateTime;
    }

    @Override
    public String toString() {
        return "ListArticle{" +
                "articleId=" + articleId +
                ", articleTitle='" + articleTitle + '\'' +
                ", typeId=" + typeId +
                ", articleType=" + articleType +
                ", isRecommend=" + isRecommend +
                ", articleViews=" + articleViews +
                ", articleLikes=" + articleLikes +
                ", articleStatus=" + articleStatus +
                ", articleUpdateTime=" + articleUpdateTime +
                '}';
    }
}
