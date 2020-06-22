package cn.liboyan.trumpetpress.controller;

import cn.liboyan.trumpetpress.model.entity.Article;
import cn.liboyan.trumpetpress.service.ArticleService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Article)表控制层
 *
 * @author Li Boyan
 * @since 2020-05-03 13:46:31
 */
@RestController
@RequestMapping("article")
public class ArticleController {
    /**
     * 服务对象
     */
    @Resource
    private ArticleService articleService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Article selectOne(Long id) {
        return this.articleService.queryById(id);
    }

}