package library.controllers;

import library.models.Book;
import library.models.Library;
import library.services.BookService;
import library.services.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public class BookController {
    @Autowired
    private BookService bookService;


    @PostMapping("/api/book")
    public void save(@RequestBody Book book){
        bookService.save(book);
    }

    @GetMapping("/api/book")
    public List<Book> getAll(){
        return (List<Book>) bookService.getAll();
    }

    @GetMapping ("/api/book/{id}")
    public Book get(@PathVariable("id") Long id) {
        return bookService.get(id);
    }

}
