package org.pmf.rzk.bookservice.service;

import org.pmf.rzk.bookservice.model.Book;
import org.pmf.rzk.bookservice.repo.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public Book addBook(Book book) {
        if (book.getPrice().compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Cena mora biti veca od 0");
        }
        return bookRepository.save(book);
    }

    public List<Book> searchBooks(String keyword) {
        return bookRepository.findByTitleContaining(keyword);
    }

    public Double calculateTotalPrice(List<Long> bookIds) {
        return bookRepository.findAllById(bookIds).stream()
                .mapToDouble(book -> book.getPrice().doubleValue())
                .sum();
    }
}
