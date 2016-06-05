package homelibrary.sorter

import homelibrary.model.Author
import homelibrary.model.enums.Nationality
import jersey.repackaged.com.google.common.collect.Lists
import spock.lang.Specification


class AuthorNationalitySorterTest extends Specification {

    def "sorts by nationality"() {
        setup:
        List<Author> unsortedList = Lists.newArrayList(
                Author.builder().nationality(Nationality.PL).build(),
                Author.builder().nationality(Nationality.IL).build(),
                Author.builder().nationality(Nationality.DE).build(),
                Author.builder().nationality(Nationality.GB).build(),
                Author.builder().nationality(Nationality.NO).build(),
        )
        AuthorNationalitySorter authorNationalitySorter = new AuthorNationalitySorter()

        when:
        List<Author> sortedList = authorNationalitySorter.sort unsortedList

        then:
        sortedList.get(0).nationality == Nationality.DE
        sortedList.get(1).nationality == Nationality.GB
        sortedList.get(2).nationality == Nationality.IL
        sortedList.get(3).nationality == Nationality.NO
        sortedList.get(4).nationality == Nationality.PL
    }
}