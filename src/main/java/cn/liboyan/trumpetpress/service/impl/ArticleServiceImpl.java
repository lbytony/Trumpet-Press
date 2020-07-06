package cn.liboyan.trumpetpress.service.impl;

import cn.liboyan.trumpetpress.exception.NotFoundException;
import cn.liboyan.trumpetpress.model.entity.Article;
import cn.liboyan.trumpetpress.model.dao.ArticleDao;
import cn.liboyan.trumpetpress.model.entity.Tag;
import cn.liboyan.trumpetpress.model.entity.TagArticle;
import cn.liboyan.trumpetpress.model.vo.ListArticle;
import cn.liboyan.trumpetpress.model.vo.SearchArticle;
import cn.liboyan.trumpetpress.model.vo.ShowIndexArticle;
import cn.liboyan.trumpetpress.service.ArticleService;
import cn.liboyan.trumpetpress.service.TagArticleService;
import cn.liboyan.trumpetpress.service.TagService;
import cn.liboyan.trumpetpress.utils.MarkdownUtils;
import cn.liboyan.trumpetpress.utils.MyBeanUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Resource
    private TagArticleService tagArticleService;

    @Resource
    private TagService tagService;

    /**
     * 通过ID查询单条数据
     *
     * @param articleId 主键
     * @param onShow    是否为前端博客展示
     * @return 实例对象
     */
    @Override
    public Article queryById(Long articleId, boolean onShow) {
        Article article = this.articleDao.queryById(articleId);
        article.init();
        if (onShow) {
            Article a = new Article();
            BeanUtils.copyProperties(article, a);
            String content = a.getArticleContent();
            content = MarkdownUtils.markdownToHtmlExtensions(content);
            a.setArticleContent(content);
            return a;
        }
        return article;
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
     * @param article 实例对象
     * @return 实例对象
     */
    @Override
    public int insert(Article article) {
        // 设置时间
        article.setArticleCreateTime(new Date());
        article.setArticleUpdateTime(new Date());
        article = setBooleans(article);
        int result = this.articleDao.insert(article);
        tagArticleService.insertTags(article.getArticleTags(), article.getArticleId());
        return result;
    }

    /**
     * 修改数据
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
        tagArticleService.update(article1.getArticleTags(), article1.getArticleId());
        return this.articleDao.update(article1);
    }

    /**
     * 通过主键删除数据
     * @param articleId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long articleId) {
        this.tagArticleService.deleteByArticleId(articleId);
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
        return this.articleDao.queryBySearch(article);
    }

    @Override
    public List<ShowIndexArticle> queryByIndexSearch(SearchArticle article) {
        return this.articleDao.queryByIndexSearch(article);
    }

    @Override
    public List<ShowIndexArticle> queryByGlobalSearch(String query) {
        return this.articleDao.queryByGlobalSearch(query);
    }

    @Override
    public List<ShowIndexArticle> queryByTagId(Long tagId) {
        List<ShowIndexArticle> articles = this.articleDao.queryByTagId(tagId);
        for (ShowIndexArticle article : articles) {
            article.setArticleTagsName(tagService.queryAllNames(article.getArticleTags()));
        }
        return articles;
    }

    @Override
    public Map<String, List<Article>> archiveArticle() {
        List<String> years = articleDao.queryAllYears();
        Map<String, List<Article>> map = new HashMap<>();
        for (String year : years) {
            map.put(year, articleDao.queryByYear(year));
        }
        return map;
    }

    private Article setBooleans(Article article) {
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
        return article;
    }
}