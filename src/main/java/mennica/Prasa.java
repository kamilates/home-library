package mennica;

public class Prasa {

    public static Pieniadz odcisnijBanknot(int wartoscNominalu) {
        return new Banknot(KonwerterNominalow.konwertujZWartosciNominalu(wartoscNominalu));
    }

}
