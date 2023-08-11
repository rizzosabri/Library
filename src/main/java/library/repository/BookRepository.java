package library.repository;

import library.models.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

    public interface BookRepository extends CrudRepository<Book, Long> {
}
