package bookregister.sorter

import bookregister.model.Book
import jersey.repackaged.com.google.common.collect.Lists
import spock.lang.Specification


class BookTitleSorterTest extends Specification {

    def "sorts by title"() {
        setup:
        List<Book> unsortedList = Lists.newArrayList(
                Book.builder().title("Pan Tadeusz").build(),
                Book.builder().title("Nad Niemnem").build(),
                Book.builder().title("Weronika musi umrzeć").build(),
                Book.builder().title("Ulisses").build(),
                Book.builder().title("Lalka").build(),
        )
        BookTitleSorter bookTitleSorter = new BookTitleSorter()

        when:
        List<Book> sortedList = bookTitleSorter.sort unsortedList

        then:
        sortedList.get(0).title == "Lalka"
        sortedList.get(1).title == "Nad Niemnem"
        sortedList.get(2).title == "Pan Tadeusz"
        sortedList.get(3).title == "Ulisses"
        sortedList.get(4).title == "Weronika musi umrzeć"
    }
}