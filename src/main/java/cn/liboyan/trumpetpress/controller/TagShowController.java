package cn.liboyan.trumpetpress.controller;

import cn.liboyan.trumpetpress.model.entity.Article;
import cn.liboyan.trumpetpress.model.entity.Tag;
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
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.List;

/**
 * TypeShowController
 *
 * @author Li Boyan
 * @version 1.0
 * @date 2020/7/6
 */
@Controller
public class TagShowController {

    @Resource
    private TypeService typeService;

    @Resource
    private TagService tagService;

    @Resource
    private ArticleService articleService;

    @GetMapping("/tags/{id}")
    public String tags(Model model, @PathVariable Long id,
                       @RequestParam(defaultValue = "1", value = "pageNum") Integer pageNum) {
        List<Tag> tags = tagService.queryListAll();
        System.err.println(tags);
        if (id == -1 && tags != null) {
            id = tags.get(0).getTagId();
        }
        model.addAttribute("tags", tags);
        PageHelper.startPage(pageNum, 6);
        List<ShowIndexArticle> list = articleService.queryByTagId(id);
        for (int i = 0; i < list.size(); i++) {
            ShowIndexArticle a = list.get(i);
            Long articleId = a.getArticleId();
            Article articleFull = articleService.queryById(articleId, true);
            a.setArticleTagsName(tagService.queryAllNames(articleFull.getArticleTags()));
            list.set(i, a);
        }
        System.err.println(list);
        PageInfo<ShowIndexArticle> pageInfo = new PageInfo<>(list);
        model.addAttribute("pageInfo", pageInfo);
        model.addAttribute("activeId", id);
        model.addAttribute("articleCount", articleService.countAllArticle());
        model.addAttribute("typeCount", typeService.countAllTypes());
        model.addAttribute("tagCount", tagService.countAllTags());
        return "tags";
    }
}
