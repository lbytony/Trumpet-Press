package cn.liboyan.trumpetpress.service;

import cn.liboyan.trumpetpress.model.entity.Article;
import cn.liboyan.trumpetpress.model.vo.ListArticle;
import cn.liboyan.trumpetpress.model.vo.SearchArticle;
import cn.liboyan.trumpetpress.model.vo.ShowIndexArticle;

import java.util.List;
import java.util.Map;

/**
 * (Article)表服务接口
 *
 * @author Li Boyan
 * @since 2020-05-03 13:44:08
 */
public interface ArticleService {

    /**
     * 通过ID查询单条数据
     *
     * @param articleId 主键
     * @return 实例对象
     */
    Article queryById(Long articleId, boolean onShow);

    /**
     * 通过title查询单条数据
     *
     * @param articleTitle 标题
     * @return 实例对象
     */
    Article queryByTitle(String articleTitle);

    /**
     * 通过title查询单条数据
     *
     * @return 对象列表
     */
    List<Article> queryAll();

    /**
     * 通过title查询单条数据
     *
     * @return 对象列表
     */
    List<ListArticle> queryListAll();

    /**
     * 通过title查询单条数据
     *
     * @return 对象列表
     */
    List<ShowIndexArticle> queryIndexAll();

    /**
     * 新增数据
     *
     * @param article 实例对象
     * @return 实例对象
     */
    int insert(Article article);

    /**
     * 修改数据
     *
     * @param article 实例对象
     * @return 实例对象
     */
    int update(Article article, Long id);

    /**
     * 通过主键删除数据
     *
     * @param articleId 主键
     * @return 是否成功
     */
    boolean deleteById(Long articleId);

    int countAllArticle();

    int countAllViews();

    int countAllLikes();

    List<ListArticle> queryBySearch(SearchArticle article);

    List<ShowIndexArticle> queryByIndexSearch(SearchArticle article);

    List<ShowIndexArticle> queryByGlobalSearch(String query);

    List<ShowIndexArticle> queryByTagId(Long tagId);

    Map<String, List<Article>> archiveArticle();
}