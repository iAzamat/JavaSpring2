package ru.geekbrains.LibraryEditor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class LibraryController {

    @GetMapping("/")
    public String home() {
        return LibraryService.update();
    }

    @PostMapping("/api/books/add")
    public ResponseEntity<String> addBook(@RequestBody Book book) {
        LibraryService.add(book);
        return new ResponseEntity<>("Книга успешно добавлена", HttpStatus.CREATED);
    }

    @DeleteMapping("/api/books/delete/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable long id) {
        LibraryService.delete(id);
        return new ResponseEntity<>("Книга c id: " + id + " успешно удалена", HttpStatus.OK);
    }

    @PutMapping("/api/books/update/{id}")
    public ResponseEntity<String> updateBook(@PathVariable long id, @RequestBody Book book) {
        LibraryService.change(id, book);
        return new ResponseEntity<>("Книга c id: " + id + " успешно обновлена", HttpStatus.OK);
    }
}
