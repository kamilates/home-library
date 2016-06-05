package homelibrary.web;

import homelibrary.repository.AuthorRepository;
import homelibrary.repository.BookRepository;
import homelibrary.model.Author;
import homelibrary.model.enums.Nationality;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloWorld {

    private BookRepository bookRepository;

    private AuthorRepository authorRepository;

    @Autowired
    public HelloWorld(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @RequestMapping("/")
    public String index() {
        return "index.html";
    }

}