package cn.liboyan.trumpetpress.service.impl;

import cn.liboyan.trumpetpress.model.entity.Tag;
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
    public int insert(TagArticle tagArticle) {
        return this.tagArticleDao.insert(tagArticle);
    }

    /**
     * 修改数据
     *
     * @param tags      实例对象列表
     * @param articleId 文章编号
     */
    @Override
    public void update(List<Tag> tags, Long articleId) {
        this.deleteByArticleId(articleId);
        this.insertTags(tags, articleId);

    }

    /**
     * 通过文章编号删除数据
     *
     * @param article Article外键
     * @return 是否成功
     */
    @Override
    public boolean deleteByArticleId(Long article) {
        return this.tagArticleDao.deleteByArticleId(article) > 0;
    }

    @Override
    public boolean deleteByTagId(Long tag) {
        return this.tagArticleDao.deleteByTagId(tag) > 0;
    }

    @Override
    public void insertTags(List<Tag> tags, Long articleId) {
        for (Tag tag : tags) {
            this.insert(new TagArticle(tag.getTagId(), articleId));
        }
    }
}