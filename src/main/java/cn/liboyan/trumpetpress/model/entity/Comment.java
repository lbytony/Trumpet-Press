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


    public Long getCommentId() {
        return commentId;
    }

    public void setCommentId(Long commentId) {
        this.commentId = commentId;
    }

    public Object getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(Object commentContent) {
        this.commentContent = commentContent;
    }

    public Integer getCommentLikes() {
        return commentLikes;
    }

    public void setCommentLikes(Integer commentLikes) {
        this.commentLikes = commentLikes;
    }

    public Date getCommentTime() {
        return commentTime;
    }

    public void setCommentTime(Date commentTime) {
        this.commentTime = commentTime;
    }

    public Long getParentCommentId() {
        return parentCommentId;
    }

    public void setParentCommentId(Long parentCommentId) {
        this.parentCommentId = parentCommentId;
    }

    public Long getArticleId() {
        return articleId;
    }

    public void setArticleId(Long articleId) {
        this.articleId = articleId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

}