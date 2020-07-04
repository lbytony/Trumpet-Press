package cn.liboyan.trumpetpress.service.impl;

import cn.liboyan.trumpetpress.exception.NotFoundException;
import cn.liboyan.trumpetpress.model.entity.Article;
import cn.liboyan.trumpetpress.model.dao.ArticleDao;
import cn.liboyan.trumpetpress.model.vo.ListArticle;
import cn.liboyan.trumpetpress.model.vo.SearchArticle;
import cn.liboyan.trumpetpress.model.vo.ShowIndexArticle;
import cn.liboyan.trumpetpress.service.ArticleService;
import cn.liboyan.trumpetpress.utils.MyBeanUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
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

    @Override
    public List<ShowIndexArticle> queryIndexAll() {
        return this.articleDao.queryIndexAll();
    }

    /**
     * 新增数据
     *
     * @param article 实例对象
     * @return 实例对象
     */
    @Override
    public int insert(Article article) {
        // 设置时间
        article.setArticleCreateTime(new Date());
        article.setArticleUpdateTime(new Date());
        if (article.getIsRecommend() == null) {
            article.setIsRecommend(false);
        }
        if (article.getIsOriginal() == null) {
            article.setIsOriginal(false);
        }
        if (article.getAllowAppreciate() == null) {
            article.setAllowAppreciate(true);
        }
        if (article.getAllowComment() == null) {
            article.setAllowComment(true);
        }
        return this.articleDao.insert(article);
    }

    /**
     * 修改数据
     *
     * @param article 实例对象
     * @return 实例对象
     */
    @Override
    public int update(Article article, Long id) {
        Article article1 = this.articleDao.queryById(id);
        if (article1 == null) {
            throw new NotFoundException("该博客不存在");
        }
        BeanUtils.copyProperties(article, article1, MyBeanUtils.getNullPropertyNames(article));
        article1.setArticleUpdateTime(new Date());
        return this.articleDao.update(article);
    }

    /**
     * 通过主键删除数据
     * @param articleId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long articleId) {
        return this.articleDao.deleteById(articleId) > 0;
    }

    /**
     * 查询文章数量
     * @return 文章数量
     */
    @Override
    public int countAllArticle() {
        return this.articleDao.countAllArticle();
    }

    /**
     * 查询阅读数量
     * @return 总阅读数
     */
    @Override
    public int countAllViews() {
        return this.articleDao.countAllViews();
    }

    /**
     * 查询点赞数量
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