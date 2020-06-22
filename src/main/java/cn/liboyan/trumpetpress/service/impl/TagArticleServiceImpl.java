package cn.liboyan.trumpetpress.service.impl;

import cn.liboyan.trumpetpress.model.entity.TagArticle;
import cn.liboyan.trumpetpress.model.dao.TagArticleDao;
import cn.liboyan.trumpetpress.service.TagArticleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (TagArticle)表服务实现类
 *
 * @author Li Boyan
 * @since 2020-05-03 13:44:12
 */
@Service("tagArticleService")
public class TagArticleServiceImpl implements TagArticleService {
    @Resource
    private TagArticleDao tagArticleDao;

    /**
     * 通过ID查询单条数据
     *
     * @param  tag  Tag外键
     * @param  article  Article外键
     * @return 实例对象
     */
    @Override
    public TagArticle queryById(Long tag, Long article) {
        return this.tagArticleDao.queryById(tag, article);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<TagArticle> queryAllByLimit(int offset, int limit) {
        return this.tagArticleDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param tagArticle 实例对象
     * @return 实例对象
     */
    @Override
    public TagArticle insert(TagArticle tagArticle) {
        this.tagArticleDao.insert(tagArticle);
        return tagArticle;
    }

    /**
     * 修改数据
     *
     * @param tagArticle 实例对象
     * @return 实例对象
     */
    @Override
    public TagArticle update(TagArticle tagArticle) {
        this.tagArticleDao.update(tagArticle);
        return this.queryById(tagArticle.getTagId(), tagArticle.getArticleId());
    }

    /**
     * 通过主键删除数据
     *
     * @param  tag  Tag外键
     * @param  article  Article外键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long tag, Long article) {
        return this.tagArticleDao.deleteById(tag, article) > 0;
    }
}