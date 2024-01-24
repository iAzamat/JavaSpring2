package ru.geekbrains.LibraryEditor;

import org.springframework.stereotype.Service;

@Service
public class LibraryService {
    public static String delete(long id){
        LibraryRepository.removeBook(id);
        return LibraryView.draw();
    }

    public static String add(Book book){
        LibraryRepository.addBook(book);
        return LibraryView.draw();
    }

    public static String change(long id, Book book){
        LibraryRepository.changeBook(id, book);
        return LibraryView.draw();
    }

    public static String update(){
        return LibraryView.draw();
    }

}
