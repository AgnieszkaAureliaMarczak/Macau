package macau;

public class Komputer extends Gracz {

    public Komputer(int indeks) {
        super(indeks);
    }

    @Override
    public Karta wybierzKarte(Karta kartaZeStosu) {
        return dajPasujacaKarteDoZagrania(kartaZeStosu);
    }
}
