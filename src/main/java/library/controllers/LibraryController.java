package library.controllers;

import library.models.Library;
import library.repository.LibraryRepository;
import library.services.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class LibraryController {

    @Autowired
    private LibraryService libraryService;


    @PostMapping("/api/library")
    public void save(@RequestBody Library library){
        libraryService.save(library);
    }

    @GetMapping ("/api/library")
    public List<Library> getAll(){
        return (List<Library>) libraryService.getAll();
    }

    @GetMapping ("/api/library/{id}")
    public Library get(@PathVariable("id") Long id) {
        return libraryService.get(id);
    }
}