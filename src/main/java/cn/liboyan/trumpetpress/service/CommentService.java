package cn.liboyan.trumpetpress.service;

import cn.liboyan.trumpetpress.model.entity.Comment;
import java.util.List;

/**
 * (Comment)表服务接口
 *
 * @author Li Boyan
 * @since 2020-05-03 13:44:10
 */
public interface CommentService {

    /**
     * 通过ID查询单条数据
     *
     * @param commentId 主键
     * @return 实例对象
     */
    Comment queryById(Long commentId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Comment> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param comment 实例对象
     * @return 实例对象
     */
    Comment insert(Comment comment);

    /**
     * 修改数据
     *
     * @param comment 实例对象
     * @return 实例对象
     */
    Comment update(Comment comment);

    /**
     * 通过主键删除数据
     *
     * @param commentId 主键
     * @return 是否成功
     */
    boolean deleteById(Long commentId);

}