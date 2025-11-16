package org.pmf.rzk.bookservice.DTO;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.pmf.rzk.bookservice.model.Book;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
public class BookDto {
    private Long id;
    private String title;
    private String author;
    private BigDecimal price;

    public BookDto(Long id, String title, String author, BigDecimal price) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.price = price;
    }
    public BookDto(Book book) {
        this.id = book.getId();
        this.title = book.getTitle();
        this.author = book.getAuthor();
        this.price = book.getPrice();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
