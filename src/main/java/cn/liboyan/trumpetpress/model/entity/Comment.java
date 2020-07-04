package cn.liboyan.trumpetpress.model.entity;

import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * (Comment)实体类
 *
 * @author Li Boyan
 * @since 2020-05-03 13:39:39
 */
@Data
public class Comment implements Serializable {
    private static final long serialVersionUID = -54012277137849154L;
    /**
    * 评论id
    */
    private Long commentId;
    /**
    * 评论内容
    */
    private Object commentContent;
    /**
    * 评论点赞数
    */
    private Integer commentLikes;
    /**
    * 评论时间
    */
    private Date commentTime;
    /**
    * 父评论id
    */
    private Long parentCommentId;
    /**
    * 博客ID
    */
    private Long articleId;
    /**
    * 评论人ID
    */
    private Long userId;

}