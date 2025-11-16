package org.pmf.rzk.bookservice.controller;

import org.pmf.rzk.bookservice.DTO.BookDto;
import org.pmf.rzk.bookservice.model.Book;
import org.pmf.rzk.bookservice.repo.BookRepository;
import org.pmf.rzk.bookservice.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookService bookService;
    @Autowired
    private BookRepository bookRepo;

    @PostMapping
    public Book addBook(@RequestBody Book book) {
        return bookService.addBook(book);
    }

    @GetMapping("/search")
    public List<Book> searchBooks(@RequestParam String keyword) {
        return bookService.searchBooks(keyword);
    }

    @PostMapping("/total-price")
    public Double calculateTotalPrice(@RequestBody List<Long> bookIds) {
        return bookService.calculateTotalPrice(bookIds);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookDto> getBookById(@PathVariable Long id) {
        return bookRepo.findById(id)
                .map(book -> ResponseEntity.ok(new BookDto(book)))
                .orElse(ResponseEntity.notFound().build());
    }

}
