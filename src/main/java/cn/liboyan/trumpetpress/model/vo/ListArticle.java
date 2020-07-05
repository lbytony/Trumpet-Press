package cn.liboyan.trumpetpress.model.vo;

import cn.liboyan.trumpetpress.model.entity.Type;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * ListArticle
 *
 * @author Li Boyan
 * @version 1.0
 * @date 2020/7/3
 */
@Data
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

}
