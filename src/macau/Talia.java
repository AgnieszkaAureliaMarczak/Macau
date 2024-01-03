package macau;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Talia {
    private List<Karta> karty = new ArrayList<>();
    private List<Karta> stos;

    public Talia(List<Karta> stos) {
        this.stos = stos;
    }

    public List<Karta> przygotujKarty() {
        potasujTalie(stworzTalieKart());
        return karty;
    }

    private ArrayList<Karta> stworzTalieKart() {
        ArrayList<Karta> talia = new ArrayList<>();
        Kolor[] tablicaKolorow = Kolor.values();
        Nominal[] tablicaNominalow = Nominal.values();
        for (Kolor kolor : tablicaKolorow) {
            for (Nominal nominal : tablicaNominalow) {
                talia.add(new Karta(kolor, nominal));
            }
        }
        return talia;
    }

    private void potasujTalie(List<Karta> taliaDoTasowania) {
        Random random = new Random();
        int rozmiarTalii = taliaDoTasowania.size();
        for (int i = 0; i < rozmiarTalii; i++) {
            int wylosowanaKarta = random.nextInt(taliaDoTasowania.size());
            karty.add(taliaDoTasowania.remove(wylosowanaKarta));
        }
    }

    public Karta usunPierwszaKarteZtalii() {
        if (karty.isEmpty()) {
            uzupelnijTalie();
        }
        return karty.remove(0);
    }

    private void wyswietlTalie() {
        int indeks = 1;
        for (Karta karta : karty) {
            System.out.println(indeks + ": " + karta);
            indeks++;
        }
    }

    public void uzupelnijTalie() {
        int rozmiarStosu = stos.size();
        List<Karta> taliaDoTasowania = new ArrayList<>();
        for (int i = 1; i < rozmiarStosu; i++) {
            taliaDoTasowania.add(stos.remove(i));
        }
        potasujTalie(taliaDoTasowania);
        wyswietlTalie();
    }

    public List<Karta> getKarty() {
        return karty;
    }
}
