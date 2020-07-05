package cn.liboyan.trumpetpress.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * (TagArticle)实体类
 *
 * @author Li Boyan
 * @since 2020-05-03 13:39:39
 */
@Data
@AllArgsConstructor
public class TagArticle implements Serializable {
    private static final long serialVersionUID = 462696437213624266L;
    /**
    * 标签ID
    */
    private Long tagId;
    /**
    * 博客ID
    */
    private Long articleId;

}