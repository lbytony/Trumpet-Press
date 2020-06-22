package cn.liboyan.trumpetpress.service.impl;

import cn.liboyan.trumpetpress.model.entity.ArticleType;
import cn.liboyan.trumpetpress.model.dao.ArticleTypeDao;
import cn.liboyan.trumpetpress.service.ArticleTypeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (ArticleType)表服务实现类
 *
 * @author Li Boyan
 * @since 2020-05-03 13:44:10
 */
@Service("articleTypeService")
public class ArticleTypeServiceImpl implements ArticleTypeService {
    @Resource
    private ArticleTypeDao articleTypeDao;

    /**
     * 通过ID查询单条数据
     *
     * @param typeId 主键
     * @return 实例对象
     */
    @Override
    public ArticleType queryById(Long typeId) {
        return this.articleTypeDao.queryById(typeId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<ArticleType> queryAllByLimit(int offset, int limit) {
        return this.articleTypeDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param articleType 实例对象
     * @return 实例对象
     */
    @Override
    public ArticleType insert(ArticleType articleType) {
        this.articleTypeDao.insert(articleType);
        return articleType;
    }

    /**
     * 修改数据
     *
     * @param articleType 实例对象
     * @return 实例对象
     */
    @Override
    public ArticleType update(ArticleType articleType) {
        this.articleTypeDao.update(articleType);
        return this.queryById(articleType.getTypeId());
    }

    /**
     * 通过主键删除数据
     *
     * @param typeId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long typeId) {
        return this.articleTypeDao.deleteById(typeId) > 0;
    }
}