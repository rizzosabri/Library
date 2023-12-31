package library.controllers;

import library.models.Employee;
import library.models.Library;
import library.repository.LibraryRepository;
import library.services.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


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

    /*@DeleteMapping ("/api/library/{id}")
    public Library delete(@PathVariable("id") Long id) {
        return libraryService.delete(id);
    }*/
    @DeleteMapping("/api/library/{id}")
    public void softDeleteLibrary(@PathVariable("id") Long id) {
        libraryService.softDelete(id);
    }

    /* @PutMapping("/api/library/{id}")
    public Library updateLibrary(@PathVariable("id") Long id, @RequestBody Library request) {
        return libraryService.updateLibrary(id, request);
    }*/

    @PatchMapping("/api/library/{id}")
    // actualizar datos específicos de la biblioteca
    public Library updateLibrary(@PathVariable("id") Long id, @RequestBody Map<String, Object> updates) {
        return libraryService.updateLibrary(id, (Map<String, Object>) updates);
    }
}
