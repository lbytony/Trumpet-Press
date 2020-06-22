package cn.liboyan.trumpetpress.controller;

import cn.liboyan.trumpetpress.model.entity.ArticleType;
import cn.liboyan.trumpetpress.service.ArticleTypeService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (ArticleType)表控制层
 *
 * @author Li Boyan
 * @since 2020-05-03 13:46:32
 */
@RestController
@RequestMapping("articleType")
public class ArticleTypeController {
    /**
     * 服务对象
     */
    @Resource
    private ArticleTypeService articleTypeService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public ArticleType selectOne(Long id) {
        return this.articleTypeService.queryById(id);
    }

}