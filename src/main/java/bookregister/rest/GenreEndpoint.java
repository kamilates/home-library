package bookregister.rest;

import bookregister.converter.BookConverter;
import bookregister.converter.GenreConverter;
import bookregister.model.Book;
import bookregister.model.Genre;
import bookregister.repository.GenreRepository;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Component
@Path("genres")
public class GenreEndpoint {

    private GenreRepository genreRepository;

    @Inject
    public GenreEndpoint(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findOne(@PathParam("id") Long id) {
        Genre genre = genreRepository.findOne(id);
        return Response.ok().entity(GenreConverter.toDto(genre)).build();
    }



}
