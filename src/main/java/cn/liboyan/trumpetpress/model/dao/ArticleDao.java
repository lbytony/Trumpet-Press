package cn.liboyan.trumpetpress.model.dao;

import cn.liboyan.trumpetpress.model.entity.Article;

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
     * 通过实体作为筛选条件查询
     *
     * @return 对象列表
     */
    List<Article> queryAll();

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

    Article queryByTitle(String articleTitle);

    List<Article> queryBySearch();
}