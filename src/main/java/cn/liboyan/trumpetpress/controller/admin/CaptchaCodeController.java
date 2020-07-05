package cn.liboyan.trumpetpress.controller.admin;

import cn.liboyan.trumpetpress.utils.CaptchaCodeUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.rmi.server.ExportException;


/**
 * CaptchaCodeController
 *
 * @author Li Boyan
 * @version 1.0
 * @date 2020/6/25
 */
@Controller
public class CaptchaCodeController {

    public final Logger logger = LoggerFactory.getLogger(this.getClass());

    @GetMapping("/getCaptchaCode")
    public void getCaptchaCode(HttpServletRequest request, HttpServletResponse response) {
        int height = 150;
        int width = 50;
        //生成对应宽高的初始图片
        BufferedImage verifyImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        //单独的一个类方法，出于代码复用考虑，进行了封装。功能是生成验证码字符并加上噪点，干扰线，返回值为验证码字符
        String code = CaptchaCodeUtils.generateVerifyCode(4);
        request.getSession().setAttribute("captcha", code);
        //必须设置响应内容类型为图片，否则前台不识别
        response.setContentType("image/jpg");
        //获取文件输出流
        OutputStream os = null;
        try {
            os = response.getOutputStream();
            //输出图片
            CaptchaCodeUtils.outputImage(height, width, os, code);
            logger.info("验证码已生成：" + code);
            os.flush();
            os.close();//关闭流
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
