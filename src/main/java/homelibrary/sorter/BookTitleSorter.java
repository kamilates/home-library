package homelibrary.sorter;

import homelibrary.model.Book;

import java.util.List;
import java.util.stream.Collectors;

public class BookTitleSorter extends AbstractSorter implements BookSorter {

    public List<Book> sort(List<Book> unsortedList) {
        return unsortedList.stream()
                .sorted((base, compare) -> base.getTitle().compareTo(compare.getTitle()))
                .collect(Collectors.toList());
    }


}
