package bookregister.converter;

import bookregister.model.Book;
import bookregister.model.Genre;
import bookregister.rest.dto.BookDto;
import bookregister.rest.dto.GenreDto;
import jersey.repackaged.com.google.common.collect.Sets;

import java.util.Iterator;
import java.util.Set;
import java.util.stream.Collectors;

public class GenreConverter {

    public static GenreDto toDto(Genre genre) {
        return GenreDto.builder()
                .id(genre.getId())
                .name(genre.getName())
                .books(getBooks(genre.getBooks()))
                .build();
    }

    private static Set<BookDto> getBooks(Set<Book> bookSet) {
//        if (bookSet == null) {
//            return null;
//        }
//
//        Iterator<Book> bookIterator = bookSet.iterator();
//        Set<BookDto> bookDtoSet = Sets.newHashSet();
//
//        while(bookIterator.hasNext()) {
//            bookDtoSet.add(BookConverter.toDto(bookIterator.next()));
//        }
//
//        return bookDtoSet;

        return bookSet.stream().map(BookConverter::toDto).collect(Collectors.toSet());
    }

}
