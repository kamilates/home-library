package homelibrary.sorter;

import java.util.List;

public interface Sorter<T> {

    List<T> sort(List<T> unorderedList);

}
