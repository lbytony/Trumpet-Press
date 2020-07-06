package cn.liboyan.trumpetpress.model.dao;

import cn.liboyan.trumpetpress.model.entity.Article;
import cn.liboyan.trumpetpress.model.vo.ListArticle;
import cn.liboyan.trumpetpress.model.vo.SearchArticle;
import cn.liboyan.trumpetpress.model.vo.ShowIndexArticle;

import java.util.List;

/**
 * (Article)表数据库访问层
 *
 * @author Li Boyan
 * @since 2020-05-03 13:40:33
 */
public interface ArticleDao {

    /**
     * 通过ID查询单条数据
     *
     * @param articleId 主键
     * @return 实例对象
     */
    Article queryById(Long articleId);

    /**
     * 查询所有
     * @return 对象列表
     */
    List<Article> queryAll();

    /**
     * 在列表中查询所有
     *
     * @return 对象列表
     */
    List<ListArticle> queryListAll();

    Article queryByTitle(String articleTitle);

    List<ListArticle> queryBySearch(SearchArticle searchArticle);

    List<ShowIndexArticle> queryByIndexSearch(SearchArticle searchArticle);

    List<ShowIndexArticle> queryIndexAll();

    List<ShowIndexArticle> queryByGlobalSearch(String query);

    List<ShowIndexArticle> queryByTagId(Long tagId);

    /**
     * 新增数据
     *
     * @param article 实例对象
     * @return 影响行数
     */
    int insert(Article article);

    /**
     * 修改数据
     *
     * @param article 实例对象
     * @return 影响行数
     */
    int update(Article article);

    /**
     * 通过主键删除数据
     *
     * @param articleId 主键
     * @return 影响行数
     */
    int deleteById(Long articleId);

    int countAllArticle();

    int countAllLikes();

    int countAllViews();

}