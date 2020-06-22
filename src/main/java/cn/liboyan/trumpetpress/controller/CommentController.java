package cn.liboyan.trumpetpress.controller;

import cn.liboyan.trumpetpress.model.entity.Comment;
import cn.liboyan.trumpetpress.service.CommentService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Comment)表控制层
 *
 * @author Li Boyan
 * @since 2020-05-03 13:46:32
 */
@RestController
@RequestMapping("comment")
public class CommentController {
    /**
     * 服务对象
     */
    @Resource
    private CommentService commentService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Comment selectOne(Long id) {
        return this.commentService.queryById(id);
    }

}