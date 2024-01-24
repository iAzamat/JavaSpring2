package ru.geekbrains.LibraryEditor;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LibraryHomeController {
    //@GetMapping("/")
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home() {
        return LibraryService.update();
    }
}
