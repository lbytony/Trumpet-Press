package cn.liboyan.trumpetpress.controller.admin;

import cn.liboyan.trumpetpress.model.entity.User;
import cn.liboyan.trumpetpress.service.ArticleService;
import cn.liboyan.trumpetpress.service.TagService;
import cn.liboyan.trumpetpress.service.TypeService;
import cn.liboyan.trumpetpress.service.UserService;
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
 * LoginController
 *
 * @author Li Boyan
 * @version 1.0
 * @date 2020/6/23
 */
@Controller
@RequestMapping("/tp-admin")
public class LoginController {

    public final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    private UserService userService;

    @Resource
    ArticleService articleService;

    @Resource
    TypeService typeService;

    @Resource
    TagService tagService;

    /**
     * 登陆界面
     */
    @GetMapping
    public String loginPage() {
        return "admin/tp-login";
    }

    /**
     * 登录验证并跳转
     *
     * @param username 用户名
     * @param password 密码
     * @param captcha  验证码
     * @param session  登录Session
     * @param redirect 重定向
     */
    @PostMapping("/login")
    public String login(@RequestParam String username,
                        @RequestParam String password,
                        @RequestParam String captcha,
                        HttpSession session,
                        RedirectAttributes redirect, Model model) {
        User user = userService.checkUser(username, password);
        if (user != null) {
            user.setUserPassword(null);
            session.setAttribute("user", user);
            String upperCaptcha = captcha.toUpperCase();
            if (upperCaptcha.equals(session.getAttribute("captcha"))) {
                model.addAttribute("articles", articleService.countAllArticle());
                model.addAttribute("types", typeService.countAllTypes());
                model.addAttribute("tags", tagService.countAllTags());
                model.addAttribute("views", articleService.countAllViews());
                model.addAttribute("likes", articleService.countAllLikes());
                return "admin/tp-admin";
            } else {
                logger.info("验证码应为：" + session.getAttribute("captcha") + "，输入的是：" + captcha);
                redirect.addFlashAttribute("captchaMessage", "验证码错误");
                return "redirect:/tp-admin";
            }
        } else {
            redirect.addFlashAttribute("message", "用户名或密码错误");
            return "redirect:/tp-admin";
        }
    }

    /**
     * 后台管理首页
     */
    @GetMapping("/admin")
    public String login(Model model) {
        model.addAttribute("articles", articleService.countAllArticle());
        model.addAttribute("types", typeService.countAllTypes());
        model.addAttribute("tags", tagService.countAllTags());
        model.addAttribute("views", articleService.countAllViews());
        model.addAttribute("likes", articleService.countAllLikes());
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
}
