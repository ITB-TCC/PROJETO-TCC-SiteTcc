package com.itb.tcc.amazbook.amazbook.modules.file.service;

import com.itb.tcc.amazbook.amazbook.modules.file.model.FilesBook;
import com.itb.tcc.amazbook.amazbook.modules.file.repository.FileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.springframework.util.ObjectUtils.isEmpty;

@Service
@RequiredArgsConstructor
public class FileService implements SaveMultiPartFile {

    private final FileRepository fileRepository;

    private String PATH_DIRECTORY = "/D:/Pablo/Documents/images";

    //TODO - FAZER O UPLOAD DA IMAGE DO LIVRO.


}
