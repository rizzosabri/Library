package library.services;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import library.models.Book;
import library.models.Library;
import library.repository.BookRepository;
import library.repository.LibraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibraryService {

    @Autowired
    private LibraryRepository libraryRepository;


    public LibraryService(BookRepository bookRepository) {
    }
    @Transactional
    public void save(Library library){libraryRepository.save(library);
    }
    @Transactional
    public List<Library> getAll(){
        return (List<Library>) libraryRepository.findAll();
    }

    @Transactional
    public Library get(Long id) {
        return libraryRepository.findById(id).orElse(null);
    }

    @Transactional
    public Library delete(Long id) {
        Library libraryToDelete = libraryRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Library not found with id: " + id));

    /*    List<Book> booksInLibrary = bookRepository.findByLibrary(libraryToDelete);
        if (!booksInLibrary.isEmpty()) {
            throw new IllegalStateException("Cannot delete library with associated books");
        }*/
        libraryRepository.delete(libraryToDelete);
        return libraryToDelete;
    }

    public Library updateLibrary(Long id, Library request) {
        Library existingLibrary = libraryRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Library not found with id: " + id));

        // Actualizar los campos relevantes con los datos del objeto de solicitud
        existingLibrary.setName(request.getName());
        existingLibrary.setWebsite(request.getWebsite());
        existingLibrary.setEmail(request.getEmail());
        existingLibrary.setPhone(request.getPhone());

        return libraryRepository.save(existingLibrary);
    }
}
