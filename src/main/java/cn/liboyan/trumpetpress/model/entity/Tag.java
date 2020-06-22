package cn.liboyan.trumpetpress.model.entity;

import java.io.Serializable;

/**
 * (Tag)实体类
 *
 * @author Li Boyan
 * @since 2020-05-03 13:39:39
 */
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


    public Long getTagId() {
        return tagId;
    }

    public void setTagId(Long tagId) {
        this.tagId = tagId;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

}