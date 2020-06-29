package cn.liboyan.trumpetpress.model.entity;

import java.io.Serializable;

/**
 * (Type)实体类
 *
 * @author Li Boyan
 * @since 2020-05-03 13:39:39
 */
public class Type implements Serializable {
    private static final long serialVersionUID = -59197202657327624L;
    /**
     * 类型ID
     */
    private Long typeId;
    /**
     * 类型名称
     */
    private String typeName;

    /**
     * 类型文章数
     */
    private Integer typeCount;

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

    public Integer getTypeCount() {
        return typeCount;
    }

    public void setTypeCount(Integer typeCount) {
        this.typeCount = typeCount;
    }

    @Override
    public String toString() {
        return "Type{" +
                "typeId=" + typeId +
                ", typeName='" + typeName + '\'' +
                ", typeCount=" + typeCount +
                '}';
    }
}