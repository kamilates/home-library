package bookregister.repository;

import bookregister.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookRepository extends CrudRepository<Book, Long> {

    Page<Book> findAll(Pageable pageable);

    List<Book> findByTitle(String title);

    @Query("select b from books b where b.title like %?1%")
    List<Book> findLikeTitle(String title);

    @Query("select b from books b where b.title like %?1% and b.originalTitle not like %?2%")
    List<Book> findLikeTitleAndNotLikeOrigialTile(String title, String originalTitle);

}