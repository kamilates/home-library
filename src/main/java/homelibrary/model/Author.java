package homelibrary.model;

import homelibrary.model.enums.Gender;
import homelibrary.model.enums.Nationality;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Builder
@Entity(name = "authors")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String surname;

    private LocalDate birthDate;

    private LocalDate deathDate;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Enumerated(EnumType.STRING)
    private Nationality nationality;

    @ManyToMany(targetEntity = Book.class, cascade = CascadeType.ALL, mappedBy = "authors")
    private Set<Book> books;

}
