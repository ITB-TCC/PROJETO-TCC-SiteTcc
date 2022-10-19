package com.itb.tcc.amazbook.amazbook.modules.file.model;

import com.itb.tcc.amazbook.amazbook.modules.file.dto.FileRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.beans.BeanUtils;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;


@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FilesBook {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    private String fileName;
    private String fileType;
    @Lob
    private byte[] fileData;


    public static FilesBook of(FileRequest fileRequest) {
        FilesBook filesBook = new FilesBook();
        BeanUtils.copyProperties(fileRequest, filesBook);
        return FilesBook
                .builder()
                .id(filesBook.getId())
                .fileName(filesBook.getFileName())
                .fileType(filesBook.getFileType())
                .fileData(filesBook.getFileData())
                .build();
    }
}
