package cn.liboyan.trumpetpress.controller;

import cn.liboyan.trumpetpress.model.entity.User;
import cn.liboyan.trumpetpress.service.UserService;
import cn.liboyan.trumpetpress.utils.CaptchaCodeUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
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

    public final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    private UserService userService;

    @GetMapping
    public String loginPage() {
        return "admin/tp-login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username,
                        @RequestParam String password,
                        @RequestParam String captcha,
                        HttpSession session,
                        RedirectAttributes redirect) {
        User user = userService.checkUser(username, password);
        if (user != null) {
            user.setUserPassword(null);
            session.setAttribute("user", user);
            String upperCaptcha = captcha.toUpperCase();
            if (upperCaptcha.equals(session.getAttribute("captcha"))) {
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

    @GetMapping("/admin")
    public String adminPage() {
        return "admin/tp-admin";
    }

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

    @GetMapping("/types")
    public String typelist() {
        return "admin/tp-typelist";
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
