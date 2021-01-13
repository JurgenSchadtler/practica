package com.practica.practica;

import com.practica.practica.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class BookController {

    @Autowired
    private BookService bookService;


    @RequestMapping("/books")
    public List<Book> getAllBooks(){
        return bookService.getAllBooks();
    }

    @RequestMapping("/books/{id}")
    public Book getBook(@PathVariable String id){
        return bookService.getBook(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/books")
    public void addBook(@RequestBody Book book){
        bookService.addBook(book);
    }

    @RequestMapping("/book")
    @PutMapping("/{id}")
    public void updateBook(@RequestBody Book book, @PathVariable String id){
        bookService.updateBook(book,id);
    }


    @RequestMapping(method = RequestMethod.DELETE, value = "/books/{id}")
    public void deleteBook(@PathVariable String id){
        bookService.deleteBook(id);
    }
}
