package bookregister.model;

import java.time.LocalDate;
import java.util.List;

public class Book {

    private String title;

    private String originalTitle;

    private LocalDate printDate;

    private List<Genre> genre;

    private List<Author> author;

    private Boolean owned;

    private Boolean wanted;

    private Boolean read;

}
