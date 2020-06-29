package cn.liboyan.trumpetpress.controller;

import cn.liboyan.trumpetpress.service.ArticleService;
import cn.liboyan.trumpetpress.service.TagService;
import cn.liboyan.trumpetpress.service.TypeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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

    /**
     * 注销操作
     */
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("user");
        return "redirect:/tp-admin";
    }

    @GetMapping("/articles")
    public String articlelist() {
        return "admin/tp-articlelist";
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
