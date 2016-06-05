package homelibrary.rest

import homelibrary.model.Author
import homelibrary.repository.AuthorRepository
import homelibrary.rest.dto.AuthorDto
import spock.lang.Specification

import java.time.LocalDate


class AuthorEndpointTest extends Specification {

    private static final String FIRST_NAME = "Czesław"
    private static final String SURNAME = "Miłosz"
    private static final LocalDate BIRTH_DATE = LocalDate.of(1911, 6, 30)
    private static final LocalDate DEATH_DATE = LocalDate.of(2004, 8, 14)
    private static final Long ID = 1

    def "should save entity"() {
        setup:
        AuthorRepository authorRepositoryMock = Mock() {
            save(_) >> void
        }
        AuthorEndpoint authorEndpoint = new AuthorEndpoint(authorRepositoryMock)

        when:
        AuthorDto dto = new AuthorDto(ID, FIRST_NAME, SURNAME, BIRTH_DATE, DEATH_DATE)
        authorEndpoint.save(dto)

        then:
        1 * authorRepositoryMock.save(_) >> { Author entity ->
            assert entity.id == ID
            assert entity.firstName == FIRST_NAME
            assert entity.surname == SURNAME
            assert entity.birthDate == BIRTH_DATE
            assert entity.deathDate == DEATH_DATE
        }
    }


}