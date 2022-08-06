package com.dl.admin.controller;

import com.sun.deploy.net.HttpResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

/**
 * 文件上传测试：
 */
@Controller
@Slf4j
public class FormController {

    @GetMapping("/form_layouts")
    public String form_layouts() {
        return "form/form_layouts";
    }

    @PostMapping("/upload")
    public String upload(@RequestParam("email") String email,
                         @RequestParam("username") String username,
                         @RequestParam("headerImg") MultipartFile file,
                         @RequestParam("photos") MultipartFile[] files) throws IOException {
        log.info("上传的信息：email={}，username={}，headerImg={}，photos={}",email,username,file.getSize(),files.length);
        if (!file.isEmpty()) {
            File ff = new File("E:\\framework_code\\SpringBoot_Study\\springboot_03_web_admin\\target\\classes\\upload\\file");
            if (!ff.exists()){
                ff.mkdirs();
            }
            ff = new File(ff,file.getOriginalFilename());
            file.transferTo(ff);
        }
        if (files.length > 0) {
            for (MultipartFile f : files) {
                File ff = new File("E:\\framework_code\\SpringBoot_Study\\springboot_03_web_admin\\target\\classes\\upload\\files");
                if (!f.isEmpty()) {
                    if (!ff.exists()) {
                        ff.mkdirs();
                    }
                }
                ff = new File(ff,f.getOriginalFilename());
                f.transferTo(ff);
            }
        }

        return "main";
    }


}
