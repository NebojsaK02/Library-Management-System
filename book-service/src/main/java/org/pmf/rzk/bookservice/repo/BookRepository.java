package org.pmf.rzk.bookservice.repo;

import org.pmf.rzk.bookservice.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByTitleContaining(String keyword);
}