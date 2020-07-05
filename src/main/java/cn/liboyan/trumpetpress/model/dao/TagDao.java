package cn.liboyan.trumpetpress.model.dao;

import cn.liboyan.trumpetpress.model.entity.Tag;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (Tag)表数据库访问层
 *
 * @author Li Boyan
 * @since 2020-05-03 13:40:34
 */
public interface TagDao {

    /**
     * 通过ID查询单条数据
     *
     * @param tagId 主键
     * @return 实例对象
     */
    Tag queryById(Long tagId);

    /**
     * 查询所有数据
     *
     * @return 对象列表
     */
    List<Tag> queryAll();

    /**
     * 查询所有数据，含个数
     *
     * @return 对象列表
     */
    List<Tag> queryListAll();

    /**
     * 新增数据
     *
     * @param tag 实例对象
     * @return 影响行数
     */
    int insert(Tag tag);

    /**
     * 修改数据
     * @param tag 实例对象
     * @return 影响行数
     */
    int update(Tag tag);

    /**
     * 通过主键删除数据
     *
     * @param tagId 主键
     * @return 影响行数
     */
    int deleteById(Long tagId);

    /**
     * 查询标签个数
     */
    int countAllTags();

    /**
     * 通过名称查询单条数据
     *
     * @param tagName 名称
     * @return 实例对象
     */
    Tag queryByName(String tagName);
}