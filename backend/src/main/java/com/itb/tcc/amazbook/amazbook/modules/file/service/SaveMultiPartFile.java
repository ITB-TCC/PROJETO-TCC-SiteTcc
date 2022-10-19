package com.itb.tcc.amazbook.amazbook.modules.file.service;

import com.itb.tcc.amazbook.amazbook.modules.file.dto.FileRequest;
import com.itb.tcc.amazbook.amazbook.modules.file.model.FilesBook;
import org.springframework.web.multipart.MultipartFile;

public interface SaveMultiPartFile {

    void uploadLocal(MultipartFile file);
    FilesBook uploadDb(MultipartFile multipartFile);

    FilesBook downloadFile(String file);

}
