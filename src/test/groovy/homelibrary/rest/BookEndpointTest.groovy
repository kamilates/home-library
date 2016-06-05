package homelibrary.rest

import homelibrary.model.Book
import homelibrary.repository.BookRepository
import homelibrary.rest.dto.BookDto
import spock.lang.Specification

import java.time.LocalDate


class BookEndpointTest extends Specification {

    private static final String TITLE = "ZiemiaUlro"
    private static final String ORIGINAL_TITLE = "Ulro"
    private static final LocalDate PRINT_DATE = LocalDate.of(1980, 8, 1)
    private static final Long ID = 1

    def "should save entity"() {
        setup:
        BookRepository bookRepositoryMock = Mock() {
            save(_) >> void
        }
        BookEndpoint bookEndpoint = new BookEndpoint(bookRepositoryMock)

        when:
        BookDto dto = new BookDto(ID, TITLE, ORIGINAL_TITLE, PRINT_DATE)
        bookEndpoint.save(dto)

        then:
        1 * bookRepositoryMock.save(_) >> { Book entity ->
            assert entity.title == TITLE
            assert entity.originalTitle == ORIGINAL_TITLE
            assert entity.id == ID
            assert entity.printDate == PRINT_DATE
        }
    }
}