package com.itb.tcc.amazbook.amazbook.modules.file.repository;

import com.itb.tcc.amazbook.amazbook.modules.file.model.FilesBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FileRepository extends JpaRepository<FilesBook, Integer> {

    Optional<FilesBook> findByName(String name);
}
