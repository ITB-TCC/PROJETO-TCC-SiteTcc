package com.itb.tcc.amazbook.amazbook.modules.file.dto;

import com.itb.tcc.amazbook.amazbook.modules.file.model.FilesBook;
import com.itb.tcc.amazbook.amazbook.modules.livro.dto.LivroResponse;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FileResponse {

    private String id;
    private String fileName;
    private String fileType;
    private byte[] fileData;

    public static FileResponse of(FilesBook filesBook) {
        return FileResponse
                .builder()
                .id(filesBook.getId())
                .fileName(filesBook.getFileName())
                .fileType(filesBook.getFileType())
                .fileData(filesBook.getFileData())
                .build();
    }
}
