package cn.liboyan.trumpetpress.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * AdminController
 * @author Li Boyan
 * @version 1.0
 * @date 2020/6/23
 */
@Controller
@RequestMapping("/tp-admin")
public class AdminController {

    @GetMapping("/setting")
    public String setting() {
        return "admin/tp-setting";
    }

}
