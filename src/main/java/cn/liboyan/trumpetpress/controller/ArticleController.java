package cn.liboyan.trumpetpress.controller;

import cn.liboyan.trumpetpress.model.entity.Article;
import cn.liboyan.trumpetpress.model.entity.User;
import cn.liboyan.trumpetpress.model.vo.ListArticle;
import cn.liboyan.trumpetpress.model.vo.SearchArticle;
import cn.liboyan.trumpetpress.service.ArticleService;
import cn.liboyan.trumpetpress.service.TagService;
import cn.liboyan.trumpetpress.service.TypeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

/**
 * ArticleController
 *
 * @author Li Boyan
 * @version 1.0
 * @date 2020/6/26
 */
@Controller
@RequestMapping("/tp-admin")
public class ArticleController {

    public final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    private ArticleService articleService;

    @Resource
    private TypeService typeService;

    @Resource
    private TagService tagService;

    /**
     * 返回分类列表
     */
    @GetMapping("/articles")
    public String showList(Model model, @RequestParam(defaultValue = "1", value = "pageNum") Integer pageNum) {
        //按照排序字段 倒序 排序
        String orderBy = "'article_update_time' desc";
        PageHelper.startPage(pageNum, 10, orderBy);
        List<ListArticle> list = articleService.queryListAll();
        PageInfo<ListArticle> pageInfo = new PageInfo<>(list);
        model.addAttribute("pageInfo", pageInfo);
        model.addAttribute("types", typeService.queryAll());
        return "admin/tp-articlelist";
    }

    /**
     * 返回文章列表
     */
    @GetMapping("/articles/input")
    public String input(Model model) {
        model.addAttribute("article", new Article());
        model.addAttribute("types", typeService.queryAll());
        model.addAttribute("tags", tagService.queryAll());
        return "admin/tp-article";
    }

    /**
     * Post新建文章
     */
    @PostMapping("/articles/input")
    public String inputPost(Article article, String tagIds, RedirectAttributes redirect, HttpSession session) {
        // 设置分类信息
        article.setArticleType(typeService.queryById(article.getTypeId()));
        // 设置标签信息
        article.setArticleTags(tagService.queryByIds(tagIds));
        System.err.println(article);
        System.err.println(tagIds);
        int t = articleService.insert(article);
        if (t == 0) {
            redirect.addFlashAttribute("type", "error");
            redirect.addFlashAttribute("message", "新增失败");
        } else {
            redirect.addFlashAttribute("type", "success");
            redirect.addFlashAttribute("message", "新增成功");
        }
        return "redirect:/tp-admin/articles";
    }

    /**
     * 跳转修改文章
     */
    @GetMapping("/articles/edit/{id}")
    public String editInput(@PathVariable Long id, Model model) {
        Article article = articleService.queryById(id);
        System.err.println(article);
        article.init();
        model.addAttribute("article", article);
        model.addAttribute("types", typeService.queryAll());
        model.addAttribute("tags", tagService.queryAll());
        model.addAttribute("tagIds", article.getTagIds());
        return "admin/tp-article";
    }

    /**
     * 修改文章条目
     */
    @PostMapping("/articles/edit/{id}")
    public String editPost(Article article, RedirectAttributes redirect, @PathVariable Long id, String tagIds) {
        article.setArticleId(id);
        article.setArticleUpdateTime(new Date());
        // 设置分类信息
        article.setArticleType(typeService.queryById(article.getTypeId()));
        // 设置标签信息
        article.setArticleTags(tagService.queryByIds(tagIds));
        System.err.println(article);
        int t = articleService.update(article, id);
        logger.info("修改完成 " + t);
        if (t == 0) {
            redirect.addFlashAttribute("type", "error");
            redirect.addFlashAttribute("message", "编辑失败");
        } else {
            redirect.addFlashAttribute("type", "success");
            redirect.addFlashAttribute("message", "编辑成功");
        }
        return "redirect:/tp-admin/articles";
    }

    /**
     * 删除文章条目
     * @param id 删除编号
     */
    @GetMapping("/articles/delete/{id}")
    public String delete(@PathVariable Long id, RedirectAttributes redirect) {
        articleService.deleteById(id);
        redirect.addFlashAttribute("type", "success");
        redirect.addFlashAttribute("message", "删除成功");
        return "redirect:/tp-admin/articles";
    }

    /**
     * 搜索博客
     */
    @PostMapping("/articles/search")
    public String search(SearchArticle searchArticle, Model model,
                         @RequestParam(defaultValue = "1", value = "pageNum") Integer pageNum) {
        logger.info("in Search");
        List<ListArticle> articlesBySearch = articleService.queryBySearch(searchArticle);
        PageHelper.startPage(pageNum, 10);
        PageInfo<ListArticle> pageInfo = new PageInfo<>(articlesBySearch);
        model.addAttribute("pageInfo", pageInfo);
        return "admin/tp-articlelist :: articleList";
    }

}
