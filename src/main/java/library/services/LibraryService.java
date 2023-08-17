package library.services;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import library.models.Book;
import library.models.Library;
import library.repository.BookRepository;
import library.repository.LibraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Map;

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
    /*public Library updateLibrary(Long id, Library request) {
        Library existingLibrary = libraryRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Library not found with id: " + id));

        // Actualizar los campos relevantes con los datos del objeto de solicitud
        existingLibrary.setName(request.getName());
        existingLibrary.setWebsite(request.getWebsite());
        existingLibrary.setEmail(request.getEmail());
        existingLibrary.setPhone(request.getPhone());

        return libraryRepository.save(existingLibrary);
    }*/

    public Library updateLibrary(Long id,@RequestBody Map<String, Object> updates) {
        Library existingLibrary = libraryRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Library not found with id: " + id));

        for (Map.Entry<String, Object> entry : updates.entrySet()) {
            String field = entry.getKey();
            Object value = entry.getValue();

            switch (field) {
                case "name":
                    existingLibrary.setName((String) value);
                    break;
                case "website":
                    existingLibrary.setWebsite((String) value);
                    break;
                case "email":
                    existingLibrary.setEmail((String) value);
                    break;
                case "phone":
                    existingLibrary.setPhone((String) value);
                    break;
                case "address":
                    existingLibrary.setAddress((String) value);
                    break;
                // Puedes agregar más campos aquí
            }
        }

        return libraryRepository.save(existingLibrary);
    }
}
