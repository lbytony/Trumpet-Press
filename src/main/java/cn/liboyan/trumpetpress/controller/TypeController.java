package cn.liboyan.trumpetpress.controller;

import cn.liboyan.trumpetpress.model.entity.Type;
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
import java.util.List;

/**
 * TypeController
 *
 * @author Li Boyan
 * @version 1.0
 * @date 2020/6/26
 */
@Controller
@RequestMapping("/tp-admin")
public class TypeController {

    public final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    private TypeService typeService;

    /**
     * 返回分类列表
     */
    @GetMapping("/types")
    public String typelist(Model model, @RequestParam(defaultValue = "1", value = "pageNum") Integer pageNum) {
        //按照排序字段 倒序 排序
        String orderBy = "'type_id' desc";
        PageHelper.startPage(pageNum, 10, orderBy);
        List<Type> list = typeService.queryAll();
        PageInfo<Type> pageInfo = new PageInfo<>(list);
        model.addAttribute("pageInfo", pageInfo);
        return "admin/tp-typelist";
    }

    /**
     * 返回分类列表
     */
    @GetMapping("/types/input")
    public String input(Model model) {
        model.addAttribute("type", new Type());
        return "admin/tp-type";
    }

    /**
     * Post新建分类
     */
    @PostMapping("/types/input")
    public String inputPost(Type type, RedirectAttributes redirect) {
        Type type1 = typeService.queryByName(type.getTypeName());
        if (type1 != null) {
            redirect.addFlashAttribute("message", "分类已重复");
            return "redirect:/tp-admin/types";
        }
        Type t = typeService.insert(type);
        if (t == null) {
            redirect.addFlashAttribute("message", "新增失败");
        } else {
            redirect.addFlashAttribute("message", "新增成功");
        }
        return "redirect:/tp-admin/types";
    }

    /**
     * 跳转修改分类
     */
    @GetMapping("/types/edit/{id}")
    public String editInput(@PathVariable Long id, Model model) {
        model.addAttribute("type", typeService.queryById(id));
        return "admin/tp-type";
    }

    /**
     * 修改分类条目
     */
    @PostMapping("/types/edit/{id}")
    public String editPost(Type type, RedirectAttributes attributes, @PathVariable Long id) {
        Type type1 = typeService.queryByName(type.getTypeName());
        if (type1 != null) {
            attributes.addFlashAttribute("message", "不能添加重复的分类");
            return "redirect:/tp-admin/types/input";
        }
        type.setTypeId(id);
        int t = typeService.update(type);
        logger.info("修改完成 " + t);
        if (t == 0) {
            attributes.addFlashAttribute("message", "编辑失败");
        } else {
            attributes.addFlashAttribute("message", "编辑成功");
        }
        return "redirect:/tp-admin/types";
    }

    /**
     * 删除分类条目
     *
     * @param id 删除编号
     */
    @GetMapping("/types/delete/{id}")
    public String delete(@PathVariable Long id, RedirectAttributes attributes) {
        typeService.deleteById(id);
        attributes.addFlashAttribute("message", "删除成功");
        return "redirect:/tp-admin/types";
    }
}
