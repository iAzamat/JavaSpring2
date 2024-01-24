package ru.geekbrains.LibraryEditor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@RestController
@Controller
@RequestMapping("/api")
public class LibraryController {
    @RequestMapping(value = "/books/items", method = RequestMethod.GET)
    public ResponseEntity<List<Book>> getItems(
            @RequestParam(value = "page", defaultValue = "1") int page,
            @RequestParam(value = "size", defaultValue = "10") int size) {
        List<Book> items = LibraryService.getItemsFromDatabase(page, size);
        if (items == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(items, HttpStatus.OK);
        }
    }

    @RequestMapping(value = "/books/{id}", method = RequestMethod.GET)
    public ResponseEntity<Book> getItem(@PathVariable("id") Long id) {
        Book book = LibraryService.getBookById(id);
        if (book == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(book, HttpStatus.OK);
        }
    }

    //@PostMapping("/api/books/add")
    @RequestMapping(value = "/books/add", method = RequestMethod.POST)
    public ResponseEntity<String> addBook(@RequestBody Book book) {
        LibraryService.add(book);
        return new ResponseEntity<>("Книга успешно добавлена", HttpStatus.CREATED);
    }

    //    @DeleteMapping("/api/books/delete/{id}")
    @RequestMapping(value = "/books/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteBook(@PathVariable("id") Long id) {
        LibraryService.delete(id);
        return new ResponseEntity<>("Книга c id: " + id + " успешно удалена", HttpStatus.OK);
    }

    //    @PutMapping("/api/books/update/{id}")
    @RequestMapping(value = "/books/update/{id}", method = RequestMethod.PUT)
    public ResponseEntity<String> updateBook(@PathVariable("id") Long id, @RequestBody Book book) {
        LibraryService.change(id, book);
        return new ResponseEntity<>("Книга c id: " + id + " успешно обновлена", HttpStatus.OK);
    }
}
