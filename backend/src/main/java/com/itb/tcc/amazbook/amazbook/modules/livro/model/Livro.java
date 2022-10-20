package com.itb.tcc.amazbook.amazbook.modules.livro.model;

import com.itb.tcc.amazbook.amazbook.modules.category.model.Category;
import com.itb.tcc.amazbook.amazbook.modules.file.model.FilesBook;
import com.itb.tcc.amazbook.amazbook.modules.livro.dto.LivroRequest;
import com.itb.tcc.amazbook.amazbook.modules.user.model.Usuario;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import java.io.IOException;
import java.time.LocalDate;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "LIVRO")
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "NOME_LIVRO", length = 120)
    private String name;

    @Column(name = "AUTOR", nullable = false, length = 120)
    private String author;

    @Column(name = "EDITORA", nullable = false, length = 200)
    //editora
    private String publishingCompany;

    @Column(name = "VALOR_LIVRO")
    private Double valueBook;


    /*@Column(name = "image_book")
    @Lob
    private byte[] image;*/

    // Data de publicação
    /*@Column(name = "DATA_PUBLICACAO", updatable = false)
    private LocalDate publicationDate;*/

    /*@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "files_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "files_fk"))
    private FilesBook filesBook;*/

    @ManyToOne
    @JoinColumn(name = "FK_CATEGORY", nullable = false)
    private Category category;

    @ManyToOne
    @JoinColumn(name = "FK_USUARIO")
    private Usuario usuario;

    public static Livro of(LivroRequest livroRequest, Category category) throws IOException {
        Livro livro = new Livro();
        BeanUtils.copyProperties(livroRequest, livro);
        return Livro
                .builder()
                .name(livroRequest.getName())
                .author(livroRequest.getAuthor())
                .publishingCompany(livroRequest.getPublishingCompany())
                .valueBook(livroRequest.getValueBook())
              //  .image(livro.getImage())
                //.publicationDate(livroRequest.getPublicationDate())
                .category(category)
               // .filesBook(filesBook)
                .build();
    }
}
