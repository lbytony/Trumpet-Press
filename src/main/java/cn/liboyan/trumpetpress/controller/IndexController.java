package cn.liboyan.trumpetpress.controller;

import cn.liboyan.trumpetpress.exception.NotFoundException;
import cn.liboyan.trumpetpress.model.entity.Article;
import cn.liboyan.trumpetpress.model.entity.Tag;
import cn.liboyan.trumpetpress.model.entity.Type;
import cn.liboyan.trumpetpress.model.vo.ListArticle;
import cn.liboyan.trumpetpress.model.vo.ShowIndexArticle;
import cn.liboyan.trumpetpress.service.ArticleService;
import cn.liboyan.trumpetpress.service.TagService;
import cn.liboyan.trumpetpress.service.TypeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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

    @Resource
    private TagService tagService;

    @Resource
    private TypeService typeService;

    private void addCount(Model model) {
        model.addAttribute("articleCount", articleService.countAllArticle());
        model.addAttribute("typeCount", typeService.countAllTypes());
        model.addAttribute("tagCount", tagService.countAllTags());
    }

    @GetMapping("/")
    public String index(Model model, RedirectAttributes redirect,
                        @RequestParam(defaultValue = "1", value = "pageNum") Integer pageNum) {
        //按照排序字段 倒序 排序
        String orderBy = "'article_update_time' desc";
        PageHelper.startPage(pageNum, 6, orderBy);
        List<ShowIndexArticle> list = articleService.queryIndexAll();
        System.out.println(list);
        PageInfo<ShowIndexArticle> pageInfo = new PageInfo<>(list);
        List<Tag> tags = tagService.queryListAll();
        List<Type> types = typeService.queryAll();
        model.addAttribute("pageInfo", pageInfo);
        model.addAttribute("types", types);
        model.addAttribute("tags", tags);
        model.addAttribute("articleCount", articleService.countAllArticle());
        model.addAttribute("typeCount", typeService.countAllTypes());
        model.addAttribute("tagCount", tagService.countAllTags());
        addCount(model);
        return "index";
    }

    @PostMapping("/search")
    public String search(Model model, String query,
                         @RequestParam(defaultValue = "1", value = "pageNum") Integer pageNum) {
        PageHelper.startPage(pageNum, 6);
        List<ShowIndexArticle> list = articleService.queryByGlobalSearch("%" + query + "%");
        PageInfo<ShowIndexArticle> pageInfo = new PageInfo<>(list);
        model.addAttribute("pageInfo", pageInfo);
        model.addAttribute("query", query);
        addCount(model);
        return "search";
    }

    @GetMapping("/articles/{id}")
    public String detail(@PathVariable Long id, Model model) {
        Article article = articleService.queryById(id, true);
        model.addAttribute("article", article);
        model.addAttribute("tags", tagService.queryAllNames(article.getArticleTags()));
        addCount(model);
        return "detail";
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
