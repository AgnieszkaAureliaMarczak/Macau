package macau;

public enum Nominal {
    DWA(2, "Dwa"),
    TRZY(3, "Trzy"),
    CZTERY(4, "Cztery"),
    PIEC(5, "Pięć"),
    SZESC(6, "Sześć"),
    SIEDEM(7, "Siedem"),
    OSIEM(8, "Osiem"),
    DZIEWIEC(9, "Dziewięć"),
    DZIESIEC(10, "Dziesięć"),
    WALET(11, "Walet"),
    DAMA(12, "Dama"),
    KROL(13, "Król"),
    AS(14, "As");

    //pola - cechy
    private int numerycznaWartosc;
    private String wyswietlanaNazwa;
    //konstruktory

    Nominal(int numerycznaWartosc, String wyswietlanaNazwa) {
        this.numerycznaWartosc = numerycznaWartosc;
        this.wyswietlanaNazwa = wyswietlanaNazwa;
    }

    //metody
   public int getNumerycznaWartosc() {
        return numerycznaWartosc;
    }

   /* public int getNumerycznaWartosc() {
        return ordinal()+2;
    }*/

    @Override
    public String toString() {
        return wyswietlanaNazwa;
    }
}
