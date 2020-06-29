package cn.liboyan.trumpetpress.controller;

import cn.liboyan.trumpetpress.model.entity.User;
import cn.liboyan.trumpetpress.service.ArticleService;
import cn.liboyan.trumpetpress.service.TagService;
import cn.liboyan.trumpetpress.service.TypeService;
import cn.liboyan.trumpetpress.service.UserService;
import cn.liboyan.trumpetpress.utils.CaptchaCodeUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * AdminController
 *
 * @author Li Boyan
 * @version 1.0
 * @date 2020/6/23
 */
@Controller
@RequestMapping("/tp-admin")
public class AdminController {

    @Resource
    ArticleService articleService;

    @Resource
    TypeService typeService;

    @Resource
    TagService tagService;

    /**
     * 后台管理首页
     */
    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("article", articleService.countAllArticle());
        model.addAttribute("type", typeService.countAllType());
        model.addAttribute("tag", tagService.countAllTag());
        return "admin/tp-admin";
    }

    /**
     * 注销操作
     */
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("user");
        return "redirect:/tp-admin";
    }

    @GetMapping("/blogs")
    public String bloglist() {
        return "admin/tp-bloglist";
    }

    @GetMapping("/tags")
    public String tagslist() {
        return "admin/tp-taglist";
    }

    @GetMapping("/setting")
    public String setting() {
        return "admin/tp-setting";
    }

    @GetMapping("/article")
    public String article() {
        return "admin/tp-article";
    }
}
