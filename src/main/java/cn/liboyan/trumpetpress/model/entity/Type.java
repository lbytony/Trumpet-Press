package cn.liboyan.trumpetpress.model.entity;

import lombok.Data;

import java.io.Serializable;
/**
 * (Type)实体类
 *
 * @author Li Boyan
 * @since 2020-05-03 13:39:39
 */
@Data
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

}