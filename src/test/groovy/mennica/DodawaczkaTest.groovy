package mennica

import jersey.repackaged.com.google.common.collect.Lists
import spock.lang.Specification


class DodawaczkaTest extends Specification {

    def "umie dodawac"() {
        setup:
        List<Pieniadz> listaNominalow = Lists.newArrayList(
                Prasa.odcisnijBanknot(100),
                Prasa.odcisnijBanknot(50),
                Prasa.odcisnijBanknot(20),
                Stempel.odcisnijMonete(5),
                Stempel.odcisnijMonete(5),
                Stempel.odcisnijMonete(2),
                Stempel.odcisnijMonete(2),
                Stempel.odcisnijMonete(2),
                Stempel.odcisnijMonete(1),
        )

        Pieniadz[] tablicaNominalow = listaNominalow.toArray(new Pieniadz[listaNominalow.size()])

        when:
        int wynikDodawania = Dodawaczka.dodajWszystko(tablicaNominalow)

        then:
        wynikDodawania == 187
    }

}