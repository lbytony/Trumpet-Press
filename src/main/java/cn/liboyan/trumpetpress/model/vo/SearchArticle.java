package cn.liboyan.trumpetpress.model.vo;

/**
 * SearchArticle
 *
 * @author Li Boyan
 * @version 1.0
 * @date 2020/7/2
 */
public class SearchArticle {

    private String articleTitle;

    private Long typeId;

    private Boolean isRecommend;

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

    public Boolean getRecommend() {
        return isRecommend;
    }

    public void setRecommend(Boolean recommend) {
        isRecommend = recommend;
    }
}
