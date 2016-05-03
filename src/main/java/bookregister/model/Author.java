package bookregister.model;

import bookregister.model.enums.Gender;
import bookregister.model.enums.Nationality;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity(name = "authors")
@Data
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String surname;

    @Column
    private LocalDate birthDate;

    @Column
    private LocalDate deathDate;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Enumerated(EnumType.STRING)
    private Nationality nationality;

    @Column
    @ManyToMany(targetEntity = Book.class, cascade = CascadeType.ALL, mappedBy = "authors")
    private Set<Book> books;

}
