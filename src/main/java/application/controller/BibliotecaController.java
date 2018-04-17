package application.controller;

import domain.entity.Book;
import domain.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BibliotecaController {
    
    @Autowired
    private BookRepository bookRepository;
    
    @GetMapping("/catalogue")
    public String catalogue(Model model) {

        model.addAttribute("books", bookRepository.findAll());

        return "catalogue";
    }
}
