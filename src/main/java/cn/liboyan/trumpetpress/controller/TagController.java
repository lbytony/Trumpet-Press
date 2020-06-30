package cn.liboyan.trumpetpress.controller;

import cn.liboyan.trumpetpress.model.entity.Tag;
import cn.liboyan.trumpetpress.service.TagService;
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
 * TagController
 *
 * @author Li Boyan
 * @version 1.0
 * @date 2020/6/29
 */
@Controller
@RequestMapping("/tp-admin")
public class TagController {

    public final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    private TagService tagService;

    /**
     * 返回标签列表
     */
    @GetMapping("/tags")
    public String showList(Model model, @RequestParam(defaultValue = "1", value = "pageNum") Integer pageNum) {
        //按照排序字段 倒序 排序
        String orderBy = "'tag_id' desc";
        PageHelper.startPage(pageNum, 10, orderBy);
        List<Tag> list = tagService.queryAll();
        PageInfo<Tag> pageInfo = new PageInfo<>(list);
        model.addAttribute("pageInfo", pageInfo);
        return "admin/tp-taglist";
    }

    /**
     * 返回标签列表
     */
    @GetMapping("/tags/input")
    public String input(Model model) {
        model.addAttribute("tag", new Tag());
        return "admin/tp-tag";
    }

    /**
     * Post新建标签
     */
    @PostMapping("/tags/input")
    public String inputPost(Tag tag, RedirectAttributes redirect) {
        Tag tag1 = tagService.queryByName(tag.getTagName());
        if (tag1 != null) {
            logger.error("标签重复" + tag.getTagName());
            redirect.addFlashAttribute("type", "error");
            redirect.addFlashAttribute("message", "标签已重复，请重新输入。");
            return "redirect:/tp-admin/tags/input";
        }
        Tag t = tagService.insert(tag);
        if (t == null) {
            redirect.addFlashAttribute("type", "error");
            redirect.addFlashAttribute("message", "新增失败");
        } else {
            redirect.addFlashAttribute("type", "success");
            redirect.addFlashAttribute("message", "新增成功");
        }
        return "redirect:/tp-admin/tags";
    }

    /**
     * 跳转修改标签
     */
    @GetMapping("/tags/edit/{id}")
    public String editInput(@PathVariable Long id, Model model) {
        model.addAttribute("tag", tagService.queryById(id));
        return "admin/tp-tag";
    }

    /**
     * 修改标签条目
     */
    @PostMapping("/tags/edit/{id}")
    public String editPost(Tag tag, RedirectAttributes redirect, @PathVariable Long id) {
        Tag tag1 = tagService.queryByName(tag.getTagName());
        if (tag1 != null) {
            redirect.addFlashAttribute("type", "error");
            redirect.addFlashAttribute("message", "标签已重复，请重新输入。");
            return "redirect:/tp-admin/tags/edit/" + id;
        }
        tag.setTagId(id);
        int t = tagService.update(tag);
        logger.info("修改完成 " + t);
        if (t == 0) {
            redirect.addFlashAttribute("type", "error");
            redirect.addFlashAttribute("message", "编辑失败");
        } else {
            redirect.addFlashAttribute("type", "success");
            redirect.addFlashAttribute("message", "编辑成功");
        }
        return "redirect:/tp-admin/tags";
    }

    /**
     * 删除标签条目
     *
     * @param id 删除编号
     */
    @GetMapping("/tags/delete/{id}")
    public String delete(@PathVariable Long id, RedirectAttributes redirect) {
        tagService.deleteById(id);
        redirect.addFlashAttribute("type", "success");
        redirect.addFlashAttribute("message", "删除成功");
        return "redirect:/tp-admin/tags";
    }

}
