package org.pmf.rzk.orderservice.feign;

import org.pmf.rzk.orderservice.dto.BookDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "book-service", url = "http://localhost:8001")
public interface BookProxy {
    @GetMapping("/books/{id}")
    BookDto getBookById(@PathVariable Long id);

    @PostMapping("/books/total-price")
    Double calculateTotalPrice(@RequestBody List<Long> bookIds);
}
