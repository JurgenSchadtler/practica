package com.practica.practica;

import com.practica.practica.model.Book;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Service
public class BookService {

    List<Book> booklist = new ArrayList<Book>(Arrays.asList(
            new Book("1","El nombre del Viento", "P.Rothfuss"),
            new Book("2","La muerte feliz", "A. Camus"),
            new Book("3","El gen egoista", "R.Dawkins")
    ));

    public List<Book> getAllBooks(){
        return booklist;
    }

    public Book getBook(String id){
        return booklist.stream().filter(t -> t.getId().equals(id)).findFirst().get();
    }

    public void addBook(Book book){
        booklist.add(book);
    }

    public void updateBook(Book bok, String id){
        for(int i = 0; i < booklist.size(); i++){
            Book book   = booklist.get(i);

            if(book.getId().equals(id))
            {
                booklist.set(i,bok);
            }
        }
    }

    public void deleteBook(String id){
        booklist.removeIf(t -> t.getId().equals(id));
    }
}
