package cn.liboyan.trumpetpress.model.vo;

import lombok.Data;

/**
 * SearchArticle
 *
 * @author Li Boyan
 * @version 1.0
 * @date 2020/7/2
 */
@Data
public class SearchArticle {

    private Long articleId;

    private String articleTitle;

    private Long typeId;

    private Boolean isRecommend;

    private Boolean articleStatus;

}
