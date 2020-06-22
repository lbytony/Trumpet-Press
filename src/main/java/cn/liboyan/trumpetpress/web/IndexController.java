package cn.liboyan.trumpetpress.web;

//import cn.liboyan.trumpetpress.exception.NotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * IndexController
 *
 * @author Li Boyan
 * @version 1.0
 * @date 2020/5/20
 */
@Controller
public class IndexController {

    @GetMapping("/")
    public String index() {
//        int i = 9/0;
//        String str = null;
//        if (str == null) {
//            throw new NotFoundException("博客未找到");
//        }
//        System.out.println("=========index========");
        return "index";
    }
}
