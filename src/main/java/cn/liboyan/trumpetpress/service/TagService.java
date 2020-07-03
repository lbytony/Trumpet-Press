package cn.liboyan.trumpetpress.service;

import cn.liboyan.trumpetpress.model.entity.Tag;
import java.util.List;

/**
 * (Tag)表服务接口
 *
 * @author Li Boyan
 * @since 2020-05-03 13:44:11
 */
public interface TagService {

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
     * 新增数据
     *
     * @param tag 实例对象
     * @return 实例对象
     */
    Tag insert(Tag tag);

    /**
     * 修改数据
     *
     * @param tag 实例对象
     * @return 实例对象
     */
    int update(Tag tag);

    /**
     * 通过主键删除数据
     *
     * @param tagId 主键
     * @return 是否成功
     */
    boolean deleteById(Long tagId);

    int countAllTags();

    Tag queryByName(String tagName);

    List<Tag> queryByIds(String tagIds);
}