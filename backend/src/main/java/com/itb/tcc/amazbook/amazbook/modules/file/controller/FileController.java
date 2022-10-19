package com.itb.tcc.amazbook.amazbook.modules.file.controller;

import com.itb.tcc.amazbook.amazbook.modules.file.service.FileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/file")
@RequiredArgsConstructor
public class FileController {


    private final FileService fileService;


    @PostMapping("/upload/local")
    public void uploadLocal(@RequestParam("file") MultipartFile file) {
        fileService.uploadLocal(file);
    }

    @PostMapping("/upload/db")
    public void uploadDb(@RequestParam("file") MultipartFile file) {
        fileService.uploadDb(file);
    }

    @GetMapping("/download/{fileId}")
    public void downloadFile(@PathVariable String fileId) {
        fileService.downloadFile(fileId);
    }

}
