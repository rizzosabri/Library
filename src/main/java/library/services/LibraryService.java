package library.services;

import jakarta.transaction.Transactional;
import library.models.Library;
import library.repository.LibraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class LibraryService {

    @Autowired
    private LibraryRepository libraryRepository;

    @Transactional
    public void save(Library library){
        libraryRepository.save(library);
    }

    @Transactional
    public List<Library> getAll(){
        return (List<Library>) libraryRepository.findAll();
    }

    @Transactional
    public Library get(Long id) {
        return libraryRepository.findById(id).orElse(null);
    }
}
