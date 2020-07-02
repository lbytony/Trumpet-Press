package cn.liboyan.trumpetpress.service;

import cn.liboyan.trumpetpress.model.entity.Article;

import java.util.List;

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
    Article queryById(Long articleId);

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
     * 新增数据
     *
     * @param article 实例对象
     * @return 实例对象
     */
    Article insert(Article article);

    /**
     * 修改数据
     *
     * @param article 实例对象
     * @return 实例对象
     */
    int update(Article article);

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

    List<Article> queryBySearch(Article article);
}