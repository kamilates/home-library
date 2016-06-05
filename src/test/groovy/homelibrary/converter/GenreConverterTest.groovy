package homelibrary.converter

import homelibrary.model.Book
import homelibrary.model.Genre
import homelibrary.rest.dto.BookDto
import homelibrary.rest.dto.GenreDto
import jersey.repackaged.com.google.common.collect.Sets
import spock.lang.Specification

class GenreConverterTest extends Specification {

    private static final Long ID = 1
    private static final Long BOOK_1_ID = 3
    private static final Long BOOK_2_ID = 4
    private static final String NAME = "SF"

    def "converts Genre to GenreDto"() {
        setup:
        Genre genre = new Genre()
        genre.setId ID
        genre.setName NAME
        genre.setBooks getBooks()

        when:
        GenreDto dto = GenreConverter.toDto genre

        then:
        dto.id == ID
        dto.name == NAME
        countExistingBooks(dto.books) == 2
    }

    private static int countExistingBooks(Set<BookDto> bookDtos) {
        Iterator<BookDto> iterator = bookDtos.iterator()
        int existingBooks
        while (iterator.hasNext()) {
            BookDto bookDto = iterator.next()

            if (bookDto.id == BOOK_1_ID || bookDto.id == BOOK_2_ID) {
               existingBooks++
            }
        }
        return  existingBooks
    }

    private static Set<Book> getBooks() {
        return Sets.newHashSet(
                new Book(id: BOOK_1_ID),
                new Book(id: BOOK_2_ID)
        )
    }

}