package cn.liboyan.trumpetpress.model.entity;

import java.io.Serializable;

/**
 * (ArticleType)实体类
 *
 * @author Li Boyan
 * @since 2020-05-03 13:39:39
 */
public class ArticleType implements Serializable {
    private static final long serialVersionUID = -59197202657327624L;
    /**
    * 类型ID
    */
    private Long typeId;
    /**
    * 类型名称
    */
    private String typeName;


    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

}