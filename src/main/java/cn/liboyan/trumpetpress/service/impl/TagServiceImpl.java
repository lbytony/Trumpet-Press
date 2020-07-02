package cn.liboyan.trumpetpress.service.impl;

import cn.liboyan.trumpetpress.model.entity.Tag;
import cn.liboyan.trumpetpress.model.dao.TagDao;
import cn.liboyan.trumpetpress.service.TagService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Tag)表服务实现类
 *
 * @author Li Boyan
 * @since 2020-05-03 13:44:12
 */
@Service("tagService")
public class TagServiceImpl implements TagService {
    @Resource
    private TagDao tagDao;

    /**
     * 通过ID查询单条数据
     *
     * @param tagId 主键
     * @return 实例对象
     */
    @Override
    public Tag queryById(Long tagId) {
        return this.tagDao.queryById(tagId);
    }

    /**
     * 查询所有数据
     *
     * @return 对象列表
     */
    @Override
    public List<Tag> queryAll() {
        return this.tagDao.queryAll();
    }

    /**
     * 新增数据
     *
     * @param tag 实例对象
     * @return 实例对象
     */
    @Override
    public Tag insert(Tag tag) {
        this.tagDao.insert(tag);
        return tag;
    }

    /**
     * 修改数据
     *
     * @param tag 实例对象
     * @return 实例对象
     */
    @Override
    public int update(Tag tag) {
        return this.tagDao.update(tag);
    }

    /**
     * 通过主键删除数据
     *
     * @param tagId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long tagId) {
        return this.tagDao.deleteById(tagId) > 0;
    }

    @Override
    public int countAllTags() {
        return this.tagDao.countAllTags();
    }

    @Override
    public Tag queryByName(String tagName) {
        return this.tagDao.queryByName(tagName);
    }
}