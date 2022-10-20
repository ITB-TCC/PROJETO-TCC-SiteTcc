package com.itb.tcc.amazbook.amazbook.modules.file.model;

import com.itb.tcc.amazbook.amazbook.modules.file.dto.FileRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.beans.BeanUtils;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;


@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "files")
public class FilesBook {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "TYPE")
    private String type;

    @Column(name = "picByte", length = 1000)
    private byte[] picByte;

    public FilesBook(String name, String type, byte[] picByte) {
        this.name = name;
        this.type = type;
        this.picByte = picByte;
    }

    public static FilesBook of(FileRequest fileRequest) {
        FilesBook filesBook = new FilesBook();
        BeanUtils.copyProperties(fileRequest, filesBook);
        return FilesBook
                .builder()
                .id(filesBook.getId())
                .name(filesBook.getName())
                .type(filesBook.getType())
                .picByte(filesBook.getPicByte())
                .build();
    }
}
