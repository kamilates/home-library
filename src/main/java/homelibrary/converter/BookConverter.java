package homelibrary.converter;

import homelibrary.model.Book;
import homelibrary.rest.dto.BookDto;
import jersey.repackaged.com.google.common.collect.Lists;

import java.util.Iterator;
import java.util.List;

public class BookConverter {

    public static BookDto toDto(Book book) {
        return BookDto.builder()
                .id(book.getId())
                .title(book.getTitle())
                .originalTitle(book.getOriginalTitle())
                .printDate(book.getPrintDate())
                .build();
    }

    public static Book toEntity(BookDto dto) {
        Book book = new Book();
        book.setTitle(dto.getTitle());
        book.setOriginalTitle(dto.getOriginalTitle());
        book.setPrintDate(dto.getPrintDate());
        book.setId(dto.getId());
        return book;
    }

    public static List<BookDto> toDtos(Iterable<Book> iterable) {
        Iterator<Book> iterator = iterable.iterator();
        List<BookDto> dtos = Lists.newArrayList();

        while(iterator.hasNext()) {
            Book book = iterator.next();
            dtos.add(BookConverter.toDto(book));
        }

        return dtos;
    }
}
