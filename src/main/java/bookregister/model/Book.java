package bookregister.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Builder
@Entity(name = "books")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String originalTitle;

    @Column
    private LocalDate printDate;

    @Column(nullable = false)
    private Boolean owned;

    @Column(nullable = false)
    private Boolean wanted;

    @Column(nullable = false)
    private Boolean read;

    @Column
    @ManyToMany(targetEntity = Author.class, cascade = CascadeType.ALL)
    @JoinTable(
        name = "books_authors",
        joinColumns = @JoinColumn(
            name = "book_id",
            referencedColumnName = "id"
        ),
        inverseJoinColumns = @JoinColumn(
            name = "author_id",
            referencedColumnName = "id"
        )
    )
    private Set<Author> authors;

    @Column
    @ManyToMany(targetEntity = Genre.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "books_genres",
            joinColumns = @JoinColumn(
                    name = "book_id",
                    referencedColumnName = "id"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "genre_id",
                    referencedColumnName = "id"
            )
    )
    private Set<Genre> genres;

}
