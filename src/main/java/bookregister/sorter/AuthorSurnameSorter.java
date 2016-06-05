package bookregister.sorter;

import bookregister.model.Author;

import java.util.List;
import java.util.stream.Collectors;

public class AuthorSurnameSorter extends AbstractSorter implements AuthorSorter {

    public List<Author> sort(List<Author> unsortedList) {
        return unsortedList.stream()
                .sorted((base, compare) -> base.getSurname().compareTo(compare.getSurname()))
                .collect(Collectors.toList());
    }

}
