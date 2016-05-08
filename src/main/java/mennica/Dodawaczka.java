package mennica;

import jersey.repackaged.com.google.common.collect.Lists;

import java.util.List;

public class Dodawaczka {

    public static int dodajWszystko(Pieniadz... pieniadze) {
        List<Integer> listaIntegerow = konwertujNaListeIntegerow(pieniadze);
        return listaIntegerow.stream().mapToInt(Integer::intValue).sum();
    }

    private static List<Integer> konwertujNaListeIntegerow(Pieniadz... pieniadze) {
        List<Integer> listaIntegerow = Lists.newArrayList();
        for(int indeks = 0; indeks < pieniadze.length; indeks++) {
            Pieniadz pieniadz = pieniadze[indeks];
            Nominal nominal = pieniadz.getNominal();
            String nazwaNominalu = nominal.name();
            String wartoscNominalu = nazwaNominalu.substring(3);
            listaIntegerow.add(Integer.valueOf(wartoscNominalu));
        }

        return listaIntegerow;
    }

}
