package com.itb.tcc.amazbook.amazbook.modules.file.dto;

import lombok.Data;

import javax.persistence.Lob;

@Data
public class FileRequest {

    private String fileName;
    private String fileType;
    @Lob
    private byte[] fileData;
}
