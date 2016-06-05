package bookregister.web;

import bookregister.repository.AuthorRepository;
import bookregister.repository.BookRepository;
import bookregister.model.Author;
import bookregister.model.enums.Nationality;
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
        Author author = authorRepository.findOne(1L);
        author.setNationality(Nationality.PL);
        authorRepository.save(author);
//        Author author = new Author();
//        author.setFirstName("Czesław");
//        author.setSurname("Miłosz");
//        authorRepository.save(author);
//
//        Book book = new Book();
//        Set<Author> authors = Sets.newHashSet();
//        authors.add(author);
//        book.setAuthors(authors);
//        book.setTitle("Ziemia Urlo");
//        bookRepository.save(book);
        return "index.html";
    }

}