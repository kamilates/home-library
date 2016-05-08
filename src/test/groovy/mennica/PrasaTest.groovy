package mennica

import spock.lang.Specification


class PrasaTest extends Specification {

    def "powinien odciska banknoty"() {
        when:
        Banknot dziesieciozlotowka = Prasa.odcisnijBanknot(10)
        Banknot stuzlotowka = Prasa.odcisnijBanknot(100)

        then:
        dziesieciozlotowka instanceof Banknot
        dziesieciozlotowka.getNominal() == Nominal.PLN10
        stuzlotowka instanceof Banknot
        stuzlotowka.getNominal() == Nominal.PLN100
    }

}