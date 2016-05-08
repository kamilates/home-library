package mennica;

public class Stempel {

    public static Moneta odcisnijMonete(int wartoscNominalu) {
        return new Moneta(KonwerterNominalow.konwertujZWartosciNominalu(wartoscNominalu));
    }

//    private static Nominal konwertujWartoscNominalnaNaNominal(int wartoscNominalu) {
//        return Nominal.valueOf("PLN" + wartoscNominalu);
//
//        if (wartoscNominalu == 1) {
//            return Nominal.PLN1;
//        }
//
//        if (wartoscNominalu == 2) {
//            return Nominal.PLN2;
//        }
//
//        if (wartoscNominalu == 5) {
//            return Nominal.PLN5;
//        }
//
//        return null;
//
//        switch (wartoscNominalu) {
//            case 1:
//                return Nominal.PLN1;
//            case 2:
//                return Nominal.PLN2;
//            case 5:
//                return Nominal.PLN5;
//            default:
//                return null;
//        }
//    }

}

