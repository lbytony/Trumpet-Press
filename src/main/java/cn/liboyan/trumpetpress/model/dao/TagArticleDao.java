package cn.liboyan.trumpetpress.model.dao;

import cn.liboyan.trumpetpress.model.entity.TagArticle;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (TagArticle)表数据库访问层
 *
 * @author Li Boyan
 * @since 2020-05-03 13:40:34
 */
public interface TagArticleDao {

    /**
     * 通过ID查询单条数据
     *
     * @param  tag  Tag外键
     * @param  article  Article外键
     * @return 实例对象
     */
    TagArticle queryById(long tag, long article);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<TagArticle> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param tagArticle 实例对象
     * @return 对象列表
     */
    List<TagArticle> queryAll(TagArticle tagArticle);

    /**
     * 新增数据
     *
     * @param tagArticle 实例对象
     * @return 影响行数
     */
    int insert(TagArticle tagArticle);

    /**
     * 修改数据
     *
     * @param tagArticle 实例对象
     * @return 影响行数
     */
    int update(TagArticle tagArticle);

    /**
     * 通过主键删除数据
     *
     * @param article Article外键
     * @return 影响行数
     */
    int deleteByArticleId(Long article);

    int deleteByTagId(Long tag);

}