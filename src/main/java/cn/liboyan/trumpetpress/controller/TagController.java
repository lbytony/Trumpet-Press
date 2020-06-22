package cn.liboyan.trumpetpress.controller;

import cn.liboyan.trumpetpress.model.entity.Tag;
import cn.liboyan.trumpetpress.service.TagService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Tag)表控制层
 *
 * @author Li Boyan
 * @since 2020-05-03 13:46:33
 */
@RestController
@RequestMapping("tag")
public class TagController {
    /**
     * 服务对象
     */
    @Resource
    private TagService tagService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Tag selectOne(Long id) {
        return this.tagService.queryById(id);
    }

}