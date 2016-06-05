package homelibrary.converter

import homelibrary.model.Book
import homelibrary.rest.dto.BookDto
import spock.lang.Specification

import java.time.LocalDate

class BookConverterTest extends Specification {

    private static final String TITLE = "Zabić drozda"
    private static final String ORGINAL_TITLE = "To Kill a Mockingbird"
    private static final LocalDate PRINT_DATE = LocalDate.of(1961, 12, 13)
    private static final Long ID = 1

    def "converts Book to BookDto"() {
        setup:
        Book book = new Book()
        book.setTitle TITLE
        book.setOriginalTitle ORGINAL_TITLE
        book.setPrintDate PRINT_DATE
        book.setId ID

        when:
        BookDto dto = BookConverter.toDto book

        then:
        dto.title == TITLE
        dto.originalTitle == ORGINAL_TITLE
        dto.printDate == PRINT_DATE
        dto.id == ID
    }

    def "converts BookDto to Book"() {
        setup:
        BookDto dto = BookDto.builder()
                .title(TITLE)
                .originalTitle(ORGINAL_TITLE)
                .printDate(PRINT_DATE)
                .id(ID)
                .build()

        when:
        Book author = BookConverter.toEntity(dto)

        then:
        author.title == TITLE
        author.originalTitle == ORGINAL_TITLE
        author.printDate == PRINT_DATE
        author.id == ID
    }

}