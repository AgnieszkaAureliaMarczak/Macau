package macau;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Talia {
    private List<Card> karty = new ArrayList<>();
    private List<Card> stos;

    public Talia(List<Card> stos) {
        this.stos = stos;
    }

    public List<Card> przygotujKarty() {
        potasujTalie(stworzTalieKart());
        return karty;
    }

    private ArrayList<Card> stworzTalieKart() {
        ArrayList<Card> talia = new ArrayList<>();
        Kolor[] tablicaKolorow = Kolor.values();
        Nominal[] tablicaNominalow = Nominal.values();
        for (Kolor kolor : tablicaKolorow) {
            for (Nominal nominal : tablicaNominalow) {
                talia.add(new Card(kolor, nominal));
            }
        }
        return talia;
    }

    private void potasujTalie(List<Card> taliaDoTasowania) {
        Random random = new Random();
        int rozmiarTalii = taliaDoTasowania.size();
        for (int i = 0; i < rozmiarTalii; i++) {
            int wylosowanaKarta = random.nextInt(taliaDoTasowania.size());
            karty.add(taliaDoTasowania.remove(wylosowanaKarta));
        }
    }

    public Card usunPierwszaKarteZtalii() {
        if (karty.isEmpty()) {
            uzupelnijTalie();
        }
        return karty.remove(0);
    }

    private void wyswietlTalie() {
        int indeks = 1;
        for (Card card : karty) {
            System.out.println(indeks + ": " + card);
            indeks++;
        }
    }

    public void uzupelnijTalie() {
        int rozmiarStosu = stos.size();
        List<Card> taliaDoTasowania = new ArrayList<>();
        for (int i = 1; i < rozmiarStosu; i++) {
            taliaDoTasowania.add(stos.remove(i));
        }
        potasujTalie(taliaDoTasowania);
        wyswietlTalie();
    }

    public List<Card> getKarty() {
        return karty;
    }
}
