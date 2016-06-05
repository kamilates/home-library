package bookregister.converter

import bookregister.converter.AuthorConverter
import bookregister.model.Author
import bookregister.model.enums.Gender
import bookregister.model.enums.Nationality
import bookregister.rest.dto.AuthorDto
import spock.lang.Specification

import java.time.LocalDate

class AuthorConverterTest extends Specification {

    private static final String FIRST_NAME = "Czesław"
    private static final String SURNAME = "Miłosz"
    private static final Long ID = 1
    private static final LocalDate BIRTH_DATE = LocalDate.of(1911, 6, 30)
    private static final LocalDate DEATH_DATE = LocalDate.of(2004, 8, 14)
    private static final Gender GENDER = Gender.MALE
    private static final Nationality NATIONALITY = Nationality.PL

    def "converts Author to AuthorDto"() {
        setup:
        Author author = new Author()
        author.setFirstName FIRST_NAME
        author.setSurname SURNAME
        author.setBirthDate BIRTH_DATE
        author.setDeathDate DEATH_DATE
        author.setId ID

        when:
        AuthorDto dto = AuthorConverter.toDto author

        then:
        dto.firstName == FIRST_NAME
        dto.surname == SURNAME
        dto.birthDate == BIRTH_DATE
        dto.deathDate == DEATH_DATE
        dto.id == ID
    }

    def "converts AuthorDto to Author"() {
        setup:
        AuthorDto dto = AuthorDto.builder()
                .firstName(FIRST_NAME)
                .surname(SURNAME)
                .birthDate(BIRTH_DATE)
                .deathDate(DEATH_DATE)
                .id(ID)
                .build()

        when:
        Author author = AuthorConverter.toEntity(dto)

        then:
        author.firstName == FIRST_NAME
        author.surname == SURNAME
        author.birthDate == BIRTH_DATE
        author.deathDate == DEATH_DATE
        author.id == ID
    }

}
