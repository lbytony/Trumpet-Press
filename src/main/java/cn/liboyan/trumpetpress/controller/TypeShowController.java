package cn.liboyan.trumpetpress.controller;

import cn.liboyan.trumpetpress.model.entity.Type;
import cn.liboyan.trumpetpress.model.vo.SearchArticle;
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
public class TypeShowController {

    @Resource
    private TypeService typeService;

    @Resource
    private TagService tagService;

    @Resource
    private ArticleService articleService;

    @GetMapping("/types/{id}")
    public String types(Model model, @PathVariable Long id,
                        @RequestParam(defaultValue = "1", value = "pageNum") Integer pageNum) {
        List<Type> types = typeService.queryListAll();
        if (id == -1) {
            id = types.get(0).getTypeId();
        }
        model.addAttribute("types", types);
        SearchArticle sa = new SearchArticle();
        sa.setTypeId(id);
        sa.setArticleStatus(true);
        System.err.println(sa);
        PageHelper.startPage(pageNum, 6);
        List<ShowIndexArticle> list = articleService.queryByIndexSearch(sa);
        PageInfo<ShowIndexArticle> pageInfo = new PageInfo<>(list);
        model.addAttribute("pageInfo", pageInfo);
        model.addAttribute("activeId", id);
        model.addAttribute("articleCount", articleService.countAllArticle());
        model.addAttribute("typeCount", typeService.countAllTypes());
        model.addAttribute("tagCount", tagService.countAllTags());
        return "types";
    }
}
