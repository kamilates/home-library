//package homelibrary.repository;
//
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.Repository;
//
//import java.util.List;
//
//public interface SearchRepository extends Repository<Object, Long> {
//    @Query(value =
//            "select * from (select authors.id, 'author', authors.surname, authors.first_name " +
//            "from authors " +
//            "union all " +
//            "select books.id, 'book', books.title, books.original_title " +
//            "from books ) as whathever where " +
//            "(lower(surname) like '%?1%' or lower(first_name) like '%?1%')",
//            nativeQuery = true)
//    List<Object> findAllLike(String query);
//
//}
