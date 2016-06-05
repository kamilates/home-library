package homelibrary.rest;

import homelibrary.converter.AuthorConverter;
import homelibrary.model.Author;
import homelibrary.repository.AuthorRepository;
import homelibrary.rest.dto.AuthorDto;
import jersey.repackaged.com.google.common.collect.Lists;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Iterator;
import java.util.List;

@Component
@Path("authors")
public class AuthorEndpoint {

    private AuthorRepository authorRepository;

    @Inject
    public AuthorEndpoint(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findOne(@PathParam("id") Long id) {
        Author author = authorRepository.findOne(id);
        return Response.ok().entity(AuthorConverter.toDto(author)).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() {
        Iterable<Author> iterable = authorRepository.findAll();
        Iterator<Author> iterator = iterable.iterator();
        List<AuthorDto> dtos = Lists.newArrayList();

        while(iterator.hasNext()) {
            Author author = iterator.next();
            dtos.add(AuthorConverter.toDto(author));
        }

        return Response.ok().entity(dtos).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response save(AuthorDto dto) {
        authorRepository.save(AuthorConverter.toEntity(dto));
        return Response.ok().build();
    }
}
