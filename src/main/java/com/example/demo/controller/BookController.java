package com.example.demo.controller;

import com.example.demo.dto.Response;
import com.example.demo.model.Book;
import com.example.demo.service.BookService;
import com.example.demo.util.ResponseBuilder;
import com.example.demo.util.UrlConstrains;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(UrlConstrains.BookManagement.ROOT)
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping(UrlConstrains.BookManagement.CREATE)
    public ResponseEntity<Object> crate(@RequestBody Book book, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return ResponseEntity.badRequest()
                    .body(ResponseBuilder.getFailureResponse(bindingResult,"Bean validation error"));
        }
        Response response = bookService.crete(book);
         return getResponse(response);
    }

    @GetMapping(UrlConstrains.BookManagement.FIND_BY_ID)
    public ResponseEntity<Object> findById(@PathVariable long id){
        Response response = bookService.findById(id);
         return getResponse(response);

    }
    @GetMapping(UrlConstrains.BookManagement.ALL)
    public ResponseEntity<Object> findAllByPage(@RequestParam(required = false) Pageable pageable){

        PageRequest request = PageRequest.of(0, 20);
        if (pageable ==null){
            pageable=request;
        }
        Response re = bookService.findAllIsActive(pageable);
        return getResponse(re);
    }
    @PutMapping(UrlConstrains.BookManagement.UPDATE)
    public ResponseEntity<Object>update(@PathVariable long id,@RequestBody Book book){
        Response response = bookService.update(id, book);
        return getResponse(response);
    }
    @GetMapping(UrlConstrains.BookManagement.FIND_BY_ISBN)
    public ResponseEntity<Object> finByIsbn(@PathVariable String isbn){
        Response response = bookService.findBYIsbn(isbn);
        return getResponse(response);
    }
    @GetMapping(UrlConstrains.BookManagement.FIND_BY_AUTHOR)
    public ResponseEntity<Object>findByAuthor(@PathVariable String author){
      return   getResponse(bookService.findByAuthor(author));
    }
    @DeleteMapping(UrlConstrains.BookManagement.DELETE)
    public ResponseEntity<Object>delete(@PathVariable long id){
        return getResponse(bookService.delete(id));
    }
    private ResponseEntity<Object> getResponse(Response response) {
        return ResponseEntity.status((int) response.getStatusCode()).body(response);
    }
}
