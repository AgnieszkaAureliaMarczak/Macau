package macau;

public class Card {
    private Kolor kolor;
    private Nominal nominal;

    public Card(Kolor kolor, Nominal nominal) {
        this.kolor = kolor;
        this.nominal = nominal;
    }

    public int getNumerycznaWartosc() {
        return nominal.getNumerycznaWartosc();
    }

    public Kolor getKolor() {
        return kolor;
    }

    @Override
    public String toString() {
        return kolor + ", " + nominal;
    }
}
