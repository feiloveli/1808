package com.jk.controller;

import com.jk.client.IOssService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

@Controller
@RequestMapping("education")
public class EducationController {

    @Autowired
    private IOssService iOssService;

    /**
     * OSS阿里云上传图片
     */
    @PostMapping("updaloadImg")
    @ResponseBody
    public HashMap<String, Object> updaloadImg(HttpServletRequest request, HttpServletResponse response, MultipartFile img) throws IOException {
        HashMap<String, Object> result = new HashMap<>();
        String img2 = iOssService.uploadImg(img);
        result.put("path",img2);
        return result;
    }

}
