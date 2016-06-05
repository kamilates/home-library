package homelibrary.sorter

import homelibrary.model.Author
import jersey.repackaged.com.google.common.collect.Lists
import spock.lang.Specification


class AuthorSurnameSorterTest extends Specification {

    def "sorts by surname"() {
        setup:
        List<Author> unsortedList = Lists.newArrayList(
                Author.builder().surname("Szymborska").build(),
                Author.builder().surname("Białoszewski").build(),
                Author.builder().surname("Miłosz").build(),
                Author.builder().surname("Lem").build(),
                Author.builder().surname("Sandauer").build(),
        )
        AuthorSurnameSorter authorSurnameSorter = new AuthorSurnameSorter()

        when:
        List<Author> sortedList = authorSurnameSorter.sort unsortedList

        then:
        sortedList.get(0).surname == "Białoszewski"
        sortedList.get(1).surname == "Lem"
        sortedList.get(2).surname == "Miłosz"
        sortedList.get(3).surname == "Sandauer"
        sortedList.get(4).surname == "Szymborska"
    }

}