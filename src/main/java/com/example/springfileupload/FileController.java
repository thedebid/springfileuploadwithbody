package com.example.springfileupload;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/file")
public class FileController {
    @Autowired
    private FileService fileService;

    @Value("${project.image}")
    private String path;

    @PostMapping("/upload")
    public String fileUpload(@RequestParam("image") MultipartFile image, @RequestPart("user") User user) throws IOException {
        System.out.println(user.getTimestamp());
        return fileService.uploadImage(path, image);
    }
}
