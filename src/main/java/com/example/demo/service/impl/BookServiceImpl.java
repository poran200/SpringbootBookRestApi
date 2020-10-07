package com.example.demo.service.impl;


import com.example.demo.dto.Response;
import com.example.demo.model.Book;
import com.example.demo.repository.BookRepository;
import com.example.demo.service.BookService;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.example.demo.util.ResponseBuilder.*;

@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Response crete(Book book) {
        Optional<Book> bookOptional = bookRepository.findByIsbnAndIsActiveTrue(book.getIsbn());
        if (!bookOptional.isPresent()){
            Book saveBook = bookRepository.save(book);
            return getSuccessResponse(HttpStatus.CREATED,"Book Created",saveBook);
        }else {
           return getFailureResponse(HttpStatus.BAD_REQUEST,"Book is already exist isbn: "+book.getIsbn());
        }
    }

    @Override
    public Response findAllIsActive(Pageable pageable) {
        Page<Book> bookPage = bookRepository.findAll(pageable);
        return getSuccessResponsePage(HttpStatus.OK,"All Books ",bookPage);
    }

    @Override
    public Response update(long bookId, Book book) {
        Optional<Book> optionalBook = bookRepository.findByBookIdAndIsActiveTrue(bookId);
        if (optionalBook.isPresent()){
            BeanUtils.copyProperties(book,optionalBook.get());
            Book updateBook = bookRepository.save(optionalBook.get());
            return getSuccessResponse(HttpStatus.OK,"Book Updated",updateBook);
        }
       return getFailureResponse(HttpStatus.NOT_FOUND,"Book not found");
    }

    @Override
    public Response delete(long bookId) {
        Optional<Book> bookOptional = bookRepository.findByBookIdAndIsActiveTrue(bookId);
        if (bookOptional.isPresent()){
            bookOptional.get().setIsActive(false);
            bookRepository.save(bookOptional.get());
            return getSuccessResponse(HttpStatus.OK,"Book deleted successfully id: "+bookOptional.get().getBookId(),null);
        }else {
           return getFailureResponse(HttpStatus.NOT_FOUND,"Book not found Id: "+bookId);
        }
     }

    @Override
    public Response findById(long bookId) {
        Optional<Book> optionalBook = bookRepository.findByBookIdAndIsActiveTrue(bookId);
        return  optionalBook.map(book -> getSuccessResponse(HttpStatus.OK,"Book found",book))
                .orElse(getFailureResponse(HttpStatus.NOT_FOUND,"book not found"+bookId));
    }

    @Override
    public Response findBYIsbn(String isbn) {
        Optional<Book> optionalBook = bookRepository.findByIsbnAndIsActiveTrue(isbn);
        return  optionalBook.map(book -> getSuccessResponse(HttpStatus.OK,"book found",book))
                .orElse(getFailureResponse(HttpStatus.NOT_FOUND,"book not found Isbn: "+isbn));

    }

    @Override
    public Response findByAuthor(String author) {
        Optional<Book> optionalBook = bookRepository.findByAuthorAndIsActiveTrue(author);
        return  optionalBook.map(book -> getSuccessResponse(HttpStatus.OK,"book found",book))
                .orElse(getFailureResponse(HttpStatus.NOT_FOUND,"book not found Author: "+author));
    }
}
