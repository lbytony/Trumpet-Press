package cn.liboyan.trumpetpress.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * PdfStreamHandler
 *
 * @author Li Boyan
 * @version 1.0
 * @date 2020/6/24
 */
@Controller
public class PdfStreamController {

    @GetMapping("/previewPdf")
    public void pdfStreamHandler(String fileName, HttpServletRequest request, HttpServletResponse response) throws FileNotFoundException {
        String classpath = ResourceUtils.getURL("classpath:static/lib/pdfjs/web/resume.pdf").getPath();
        System.err.println(classpath);
        File file = new File(classpath);
        if (file.exists()) {
            byte[] data = null;
            FileInputStream input = null;
            try {
                input = new FileInputStream(file);
                data = new byte[input.available()];
                input.read(data);
                response.getOutputStream().write(data);
            } catch (Exception e) {
                System.out.println("pdf文件处理异常：" + e);
            } finally {
                try {
                    if (input != null) {
                        input.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } else {
            System.out.println("PDF文件不存在");
        }
    }
}
