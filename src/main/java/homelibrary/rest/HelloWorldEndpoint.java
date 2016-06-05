package homelibrary.rest;

import homelibrary.repository.BookRepository;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Component
@Path("/hello")
public class HelloWorldEndpoint {

    private BookRepository bookRepository;

//    @Inject
//    public HelloWorldEndpoint(BookRepository bookRepository) {
//        this.bookRepository = bookRepository;
//    }

    @GET
    public String welcome() {
        return "Hello world endpoint!";
//        Pageable pageable = new PageRequest(0, 10);
//        return "Hello world endpoint!" + bookRepository.findAll(pageable).getTotalPages();
    }

}
