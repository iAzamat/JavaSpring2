package ru.geekbrains.LibraryEditor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
//@Controller
//@RequestMapping("/api")
public class LibraryController {

    //@GetMapping("/")
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home() {
        return LibraryService.update();
    }

    @RequestMapping(value = "/api/books/{id}", method = RequestMethod.GET)
    public ResponseEntity<Book> getItem(@PathVariable("id") Long id) {
        Book book = LibraryService.getBookById(id);
        if (book == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(book, HttpStatus.OK);
        }
    }

    //@PostMapping("/api/books/add")
    @RequestMapping(value = "/api/books/add", method = RequestMethod.POST)
    public ResponseEntity<String> addBook(@RequestBody Book book) {
        LibraryService.add(book);
        return new ResponseEntity<>("Книга успешно добавлена", HttpStatus.CREATED);
    }

    //    @DeleteMapping("/api/books/delete/{id}")
    @RequestMapping(value = "/api/books/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteBook(@PathVariable("id") Long id) {
        LibraryService.delete(id);
        return new ResponseEntity<>("Книга c id: " + id + " успешно удалена", HttpStatus.OK);
    }

    //    @PutMapping("/api/books/update/{id}")
    @RequestMapping(value = "/api/books/update/{id}", method = RequestMethod.PUT)
    public ResponseEntity<String> updateBook(@PathVariable("id") Long id, @RequestBody Book book) {
        LibraryService.change(id, book);
        return new ResponseEntity<>("Книга c id: " + id + " успешно обновлена", HttpStatus.OK);
    }
}
