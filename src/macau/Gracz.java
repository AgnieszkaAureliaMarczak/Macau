package macau;

import java.util.ArrayList;
import java.util.List;

public class Gracz {
    List<Karta> karty = new ArrayList<>();
    private int indeks;

    public Gracz() {
    }

    public Gracz(int indeks) {
        this.indeks = indeks;
    }

    public void otrzymajKarte(Karta karta) {
        karty.add(karta);
    }

    public List<Karta> dajKarty() {
        return karty;
    }

    public int dajIloscKart() {
        return karty.size();
    }

    public void wyswietlKarty() {
        System.out.println("Twoje karty:");
        for (int i = 0; i < dajIloscKart(); i++) {
            System.out.println((i + 1) + ": " + karty.get(i));
        }
    }

    public boolean czyMozeszZagracNa(Karta kartaZeStosu) {
        Karta dopasowanaKarta = dajPasujacaKarteDoZagrania(kartaZeStosu);
        return dopasowanaKarta != null;
    }

    Karta dajPasujacaKarteDoZagrania(Karta kartaZeStosu) {
        for (Karta kartaZReki : karty) {
            if (kartaZReki.getKolor() == kartaZeStosu.getKolor() ||
                    kartaZReki.getNumerycznaWartosc() == kartaZeStosu.getNumerycznaWartosc()) {
                return kartaZReki;
            }
        }
        return null;
    }

    public Karta wybierzKarte(Karta kartaZeStosu) {
        System.out.println("Gracz robi ruch.");
        return null;
    }

    @Override
    public String toString() {
        return "Gracz nr " + (indeks + 1);
    }
}
