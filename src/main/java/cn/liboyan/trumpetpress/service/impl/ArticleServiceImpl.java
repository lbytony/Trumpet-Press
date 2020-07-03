package cn.liboyan.trumpetpress.service.impl;

import cn.liboyan.trumpetpress.model.entity.Article;
import cn.liboyan.trumpetpress.model.dao.ArticleDao;
import cn.liboyan.trumpetpress.model.vo.ListArticle;
import cn.liboyan.trumpetpress.model.vo.SearchArticle;
import cn.liboyan.trumpetpress.service.ArticleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Article)表服务实现类
 *
 * @author Li Boyan
 * @since 2020-05-03 13:44:09
 */
@Service("articleService")
public class ArticleServiceImpl implements ArticleService {
    @Resource
    private ArticleDao articleDao;

    /**
     * 通过ID查询单条数据
     * @param articleId 主键
     * @return 实例对象
     */
    @Override
    public Article queryById(Long articleId) {
        return this.articleDao.queryById(articleId);
    }

    /**
     * 通过title查询单条数据
     *
     * @param articleTitle 标题
     * @return 实例对象
     */
    @Override
    public Article queryByTitle(String articleTitle) {
        return this.articleDao.queryByTitle(articleTitle);
    }

    @Override
    public List<Article> queryAll() {
        return this.articleDao.queryAll();
    }

    @Override
    public List<ListArticle> queryListAll() {
        return this.articleDao.queryListAll();
    }

    /**
     * 新增数据
     *
     * @param article 实例对象
     * @return 实例对象
     */
    @Override
    public int insert(Article article) {
        return this.articleDao.insert(article);
    }

    /**
     * 修改数据
     *
     * @param article 实例对象
     * @return 实例对象
     */
    @Override
    public int update(Article article) {
        return this.articleDao.update(article);
    }

    /**
     * 通过主键删除数据
     *
     * @param articleId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long articleId) {
        return this.articleDao.deleteById(articleId) > 0;
    }

    /**
     * 查询文章数量
     *
     * @return 文章数量
     */
    @Override
    public int countAllArticle() {
        return this.articleDao.countAllArticle();
    }

    /**
     * 查询阅读数量
     *
     * @return 总阅读数
     */
    @Override
    public int countAllViews() {
        return this.articleDao.countAllViews();
    }

    /**
     * 查询点赞数量
     *
     * @return 总点赞数
     */
    @Override
    public int countAllLikes() {
        return this.articleDao.countAllLikes();
    }

    @Override
    public List<ListArticle> queryBySearch(SearchArticle article) {
        return this.articleDao.queryBySearch();
    }
}