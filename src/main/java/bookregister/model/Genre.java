package bookregister.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "genres")
@Data
public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column
    @ManyToMany(targetEntity = Book.class, cascade = CascadeType.ALL, mappedBy = "genres", fetch = FetchType.EAGER)
    private Set<Book> books;

}
