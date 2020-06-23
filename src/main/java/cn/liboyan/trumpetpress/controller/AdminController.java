package cn.liboyan.trumpetpress.controller;

import cn.liboyan.trumpetpress.model.entity.User;
import cn.liboyan.trumpetpress.service.UserService;
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

    @Resource
    private UserService userService;

    @GetMapping
    public String loginPage() {
        return "admin/tp-login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password, HttpSession session, RedirectAttributes redirect) {
        User user = userService.checkUser(username, password);
        if (user != null) {
            user.setUserPassword(null);
            session.setAttribute("user", user);
            return "admin/tp-admin";
        } else {
            redirect.addFlashAttribute("message", "用户名或密码错误");
            return "redirect:/admin";
        }
    }
}
