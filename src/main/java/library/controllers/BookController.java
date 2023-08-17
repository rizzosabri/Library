package library.controllers;

import library.models.Book;
import library.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
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
