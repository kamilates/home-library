package bookregister.rest;

import bookregister.converter.BookConverter;
import bookregister.model.Book;
import bookregister.repository.BookRepository;
import bookregister.rest.dto.BookDto;
import jersey.repackaged.com.google.common.collect.Lists;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Iterator;
import java.util.List;

@Component
@Path("books")
public class BookEndpoint {

    private BookRepository bookRepository;

    @Inject
    public BookEndpoint(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findOne(@PathParam("id") Long id) {
        Book book = bookRepository.findOne(id);
        return Response.ok().entity(BookConverter.toDto(book)).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() {
        List<BookDto> dtos = BookConverter.toDtos(bookRepository.findAll());
        return Response.ok().entity(dtos).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response save(BookDto dto) {
        bookRepository.save(BookConverter.toEntity(dto));
        return Response.ok().build();
    }

}
