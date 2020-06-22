package cn.liboyan.trumpetpress.controller;

import cn.liboyan.trumpetpress.model.entity.TagArticle;
import cn.liboyan.trumpetpress.service.TagArticleService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (TagArticle)表控制层
 *
 * @author Li Boyan
 * @since 2020-05-03 13:46:33
 */
@RestController
@RequestMapping("tagArticle")
public class TagArticleController {
    /**
     * 服务对象
     */
    @Resource
    private TagArticleService tagArticleService;

    /**
     * 通过主键查询单条数据
     *
     * @param  tag  Tag外键
     * @param  article  Article外键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public TagArticle selectOne(long tag, long article) {
        return this.tagArticleService.queryById(tag, article);
    }

}