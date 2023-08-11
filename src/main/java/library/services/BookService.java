package library.services;

import jakarta.transaction.Transactional;
import library.models.Book;
import library.models.Library;
import library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    @Transactional
    public void save(Book book){bookRepository.save(book);
    }

    @Transactional
    public List<Book> getAll(){
        return (List<Book>) bookRepository.findAll();
    }

    @Transactional
    public Book get(Long id) {
        return bookRepository.findById(id).orElse(null);
}
}