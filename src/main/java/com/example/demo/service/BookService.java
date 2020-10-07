package com.example.demo.service;


import com.example.demo.dto.Response;
import com.example.demo.model.Book;
import org.springframework.data.domain.Pageable;

public interface BookService {
    Response crete(Book book);
    Response findAllIsActive(Pageable pageable);
    Response update(long bookId,Book book);
    Response delete(long bookId);
    Response findById(long bookId);
    Response findBYIsbn(String isbn);
    Response findByAuthor(String author);
}
