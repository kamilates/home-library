package mennica

import spock.lang.Specification

class StempelTest extends Specification {

    def "powinien odciska monety"() {
        when:
        Moneta jednozlotowka = Stempel.odcisnijMonete(1)
        Moneta dwuzlotowka = Stempel.odcisnijMonete(2)
        Moneta pieciozlotowka = Stempel.odcisnijMonete(5)

        then:
        jednozlotowka instanceof Moneta
        jednozlotowka.getNominal() == Nominal.PLN1
        dwuzlotowka instanceof Moneta
        dwuzlotowka.getNominal() == Nominal.PLN2
        pieciozlotowka instanceof Moneta
        pieciozlotowka.getNominal() == Nominal.PLN5
    }

}