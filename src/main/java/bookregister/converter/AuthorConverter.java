package bookregister.converter;

import bookregister.model.Author;
import bookregister.rest.dto.AuthorDto;

public class AuthorConverter {

    public static AuthorDto toDto(Author author) {
        return AuthorDto.builder()
                .id(author.getId())
                .firstName(author.getFirstName())
                .surname(author.getSurname())
                .build();
    }

    public static Author toEntity(AuthorDto dto) {
        Author author = new Author();
        author.setFirstName(dto.getFirstName());
        author.setSurname(dto.getSurname());
        author.setId(dto.getId());
        return author;
    }

}
