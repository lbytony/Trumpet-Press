package cn.liboyan.trumpetpress.service;

import cn.liboyan.trumpetpress.model.entity.TagArticle;
import java.util.List;

/**
 * (TagArticle)表服务接口
 *
 * @author Li Boyan
 * @since 2020-05-03 13:44:12
 */
public interface TagArticleService {

    /**
     * 通过ID查询单条数据
     *
     * @param  tag  Tag外键
     * @param  article  Article外键
     * @return 实例对象
     */
    TagArticle queryById(Long tag, Long article);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<TagArticle> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param tagArticle 实例对象
     * @return 实例对象
     */
    TagArticle insert(TagArticle tagArticle);

    /**
     * 修改数据
     *
     * @param tagArticle 实例对象
     * @return 实例对象
     */
    TagArticle update(TagArticle tagArticle);

    /**
     * 通过主键删除数据
     *
     * @param  tag  Tag外键
     * @param  article  Article外键
     * @return 是否成功
     */
    boolean deleteById(Long tag, Long article);

}