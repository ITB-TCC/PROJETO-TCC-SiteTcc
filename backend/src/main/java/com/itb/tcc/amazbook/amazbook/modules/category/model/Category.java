package com.itb.tcc.amazbook.amazbook.modules.category.model;

import com.itb.tcc.amazbook.amazbook.modules.category.dto.CategoryRequest;
import com.itb.tcc.amazbook.amazbook.modules.livro.model.Livro;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "CATEGORY")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "name_category", nullable = false)
    private String nameCategory;

    public static Category of(CategoryRequest categoryResquest) {
        Category category = new Category();
        BeanUtils.copyProperties(categoryResquest, category);
        return category;
    }
}
