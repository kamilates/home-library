package mennica;

public class KonwerterNominalow {

    public static Nominal konwertujZWartosciNominalu(int wartoscNominalu) {
        return Nominal.valueOf("PLN" + wartoscNominalu);
    }

}
