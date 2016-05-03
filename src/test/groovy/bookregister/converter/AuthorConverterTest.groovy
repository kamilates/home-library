package groovy.bookregister.converter

import bookregister.converter.AuthorConverter
import bookregister.model.Author
import bookregister.rest.dto.AuthorDto
import spock.lang.Specification

class AuthorConverterTest extends Specification {

    private static final String FIRST_NAME = "Czesław"
    private static final String SURNAME = "Miłosz"
    private static final Long ID = 1

    def "converts Author to AuthorDto"() {
        setup:
        Author author = new Author()
        author.setFirstName FIRST_NAME
        author.setSurname SURNAME
        author.setId ID

        when:
        AuthorDto dto = AuthorConverter.toDto author

        then:
        dto.firstName == FIRST_NAME
        dto.surname == SURNAME
        dto.id == ID
    }

    def "converts AuthorDto to Author"() {
        setup:
        AuthorDto dto = AuthorDto.builder()
                .firstName(FIRST_NAME)
                .surname(SURNAME)
                .id(ID)
                .build()

        when:
        Author author = AuthorConverter.toEntity(dto)

        then:
        author.firstName == FIRST_NAME
        author.surname == SURNAME
        author.id == ID
    }

}
