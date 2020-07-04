package cn.liboyan.trumpetpress.controller;

import cn.liboyan.trumpetpress.exception.NotFoundException;
import cn.liboyan.trumpetpress.model.entity.Article;
import cn.liboyan.trumpetpress.model.vo.ListArticle;
import cn.liboyan.trumpetpress.model.vo.ShowIndexArticle;
import cn.liboyan.trumpetpress.service.ArticleService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import java.util.List;

/**
 * IndexController
 *
 * @author Li Boyan
 * @version 1.0
 * @date 2020/5/20
 */
@Controller
public class IndexController {

    @Resource
    private ArticleService articleService;

    @GetMapping("/")
    public String index(Model model, RedirectAttributes redirect,
                        @RequestParam(defaultValue = "1", value = "pageNum") Integer pageNum) {
        //按照排序字段 倒序 排序
        String orderBy = "'article_update_time' desc";
        PageHelper.startPage(pageNum, 10, orderBy);
        List<ShowIndexArticle> list = articleService.queryIndexAll();
        System.out.println(list);
        PageInfo<ShowIndexArticle> pageInfo = new PageInfo<>(list);
        model.addAttribute("pageInfo", pageInfo);
        return "index";
    }

    @GetMapping("/detail")
    public String detail() {
        return "detail";
    }

    @GetMapping("/archives")
    public String archives() {
        return "archives";
    }

    @GetMapping("/tags")
    public String tags() {
        return "tags";
    }

    @GetMapping("/types")
    public String types() {
        return "types";
    }

    @GetMapping("/resume")
    public String resume() {
        return "resume";
    }

    @GetMapping("/about")
    public String about() {
        return "about";
    }
}
