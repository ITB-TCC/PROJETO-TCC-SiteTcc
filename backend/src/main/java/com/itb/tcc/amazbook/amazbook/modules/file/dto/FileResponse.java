package com.itb.tcc.amazbook.amazbook.modules.file.dto;

import com.itb.tcc.amazbook.amazbook.modules.file.model.FilesBook;
import com.itb.tcc.amazbook.amazbook.modules.livro.dto.LivroResponse;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FileResponse {

    private Integer id;
    private String name;
    private String type;
    private byte[] picByte;

    public static FileResponse of(FilesBook filesBook) {
        return FileResponse
                .builder()
                .id(filesBook.getId())
                .name(filesBook.getName())
                .type(filesBook.getType())
                .picByte(filesBook.getPicByte())
                .build();
    }
}
