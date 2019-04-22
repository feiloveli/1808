package com.jk.client;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface IOssService {
    String uploadImg(MultipartFile imgs) throws IOException;
}
