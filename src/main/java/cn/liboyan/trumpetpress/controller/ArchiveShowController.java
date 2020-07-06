package cn.liboyan.trumpetpress.controller;

import cn.liboyan.trumpetpress.service.ArticleService;
import cn.liboyan.trumpetpress.service.TagService;
import cn.liboyan.trumpetpress.service.TypeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.Resource;

/**
 * TypeShowController
 *
 * @author Li Boyan
 * @version 1.0
 * @date 2020/7/6
 */
@Controller
public class ArchiveShowController {

    @Resource
    private TypeService typeService;

    @Resource
    private TagService tagService;

    @Resource
    private ArticleService articleService;

    @GetMapping("/archives")
    public String archive(Model model) {
        model.addAttribute("articleMap", articleService.archiveArticle());
        model.addAttribute("articleCount", articleService.countAllArticle());
        model.addAttribute("typeCount", typeService.countAllTypes());
        model.addAttribute("tagCount", tagService.countAllTags());
        return "archives";
    }
}
