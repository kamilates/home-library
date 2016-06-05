package homelibrary.sorter;

import homelibrary.model.Author;

import java.util.List;
import java.util.stream.Collectors;

public class AuthorNationalitySorter extends AbstractSorter implements AuthorSorter {

    public List<Author> sort(List<Author> unsortedList) {
        return unsortedList.stream().sorted((base, compare) ->
            base.getNationality().name().compareTo(compare.getNationality().name())
        ).collect(Collectors.toList());
    }

}
