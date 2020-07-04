package cn.liboyan.trumpetpress.model.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * (Tag)实体类
 *
 * @author Li Boyan
 * @since 2020-05-03 13:39:39
 */
@Data
public class Tag implements Serializable {
    private static final long serialVersionUID = 410899272658086005L;
    /**
     * 标签ID
     */
    private Long tagId;
    /**
     * 标签名称
     */
    private String tagName;

    private List<Article> tagArticles;

}