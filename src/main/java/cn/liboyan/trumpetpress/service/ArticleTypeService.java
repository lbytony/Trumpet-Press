package cn.liboyan.trumpetpress.service;

import cn.liboyan.trumpetpress.model.entity.ArticleType;
import java.util.List;

/**
 * (ArticleType)表服务接口
 *
 * @author Li Boyan
 * @since 2020-05-03 13:44:09
 */
public interface ArticleTypeService {

    /**
     * 通过ID查询单条数据
     *
     * @param typeId 主键
     * @return 实例对象
     */
    ArticleType queryById(Long typeId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<ArticleType> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param articleType 实例对象
     * @return 实例对象
     */
    ArticleType insert(ArticleType articleType);

    /**
     * 修改数据
     *
     * @param articleType 实例对象
     * @return 实例对象
     */
    ArticleType update(ArticleType articleType);

    /**
     * 通过主键删除数据
     *
     * @param typeId 主键
     * @return 是否成功
     */
    boolean deleteById(Long typeId);

}